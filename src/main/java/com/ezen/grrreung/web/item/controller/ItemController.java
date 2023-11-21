package com.ezen.grrreung.web.item.controller;

import com.ezen.grrreung.domain.item.dto.Category;
import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.net.ns.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/grrreung")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @Value("${file.dir}")
    private String location;

    // 홈화면
    @RequestMapping("/")
    public String homeItemList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);
        return "/grrreung/index";
    }

    // shop 상품 전체목록 불러오기
    @RequestMapping("/shop")
    public String allItemsList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);
        return "/grrreung/sub/shop";
    }


    // 아이템 아이디로 상품 한개 상세정보
    @GetMapping("/shop/item/{itemId}")
    public String itemInfo(@PathVariable("itemId")int itemId, Model model){
        Item item = itemService.findByItemId(itemId);
        model.addAttribute("item", item);
        return "/grrreung/sub/item";
    }


    // 썸네일 이미지 1개 불러오기 => index, shop
    @GetMapping("/thumbnail/{itemId}")
    public ResponseEntity<Resource> thumbnailImage(String fileName, @PathVariable("itemId")int itemId, Model model) throws IOException {
        String imgFileName = itemService.showThumbnail(itemId);
        log.info("파일명: {}", imgFileName);

        Path path = Paths.get(location + "/" + imgFileName);
        String contentType = Files.probeContentType(path);

		// 이미지 파일 외에는 모두 다운로드 처리
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new FileSystemResource(path);
		if(!contentType.startsWith("image")){
			// 응답 헤더에 파일정보 설정
			headers.setContentDisposition(
					ContentDisposition
							.builder("attachment")
							.filename(fileName, StandardCharsets.UTF_8).build());
			resource = new FileSystemResource(path);
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

//=============================================================================================================
    // 상품 전체 이미지 가져오기 => 상세정보 페이지에 이미지 슬라이드 나타낼 부분
    @GetMapping("/itemImages/{itemId}")
//    public ResponseEntity<Resource> itemImages(@PathVariable("itemId")int itemId, Model model) throws IOException {
    public ResponseEntity<Map<String, Object>> itemImages(@PathVariable("itemId")int itemId,@ModelAttribute Model model) throws IOException {
        List<Map<String, Object>> imgFiles = itemService.showImageSlide(itemId);

        String imageName = "";
        Resource resource = null;
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> result = new HashMap<>();

        int i = 1;

        for(Map<String, Object>  map : imgFiles) {
            imageName = (String) map.get("IMG_NAME");
            log.info("1)파일명 : {}", imageName);
            Path path = Paths.get(location + "/" + imageName);
            String contentType = Files.probeContentType(path);
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            resource = new FileSystemResource(path);

            result.put("file"+i, resource);
            i++;
            model.addAttribute("result", result.get("file"+i));
        }
        log.info("2) 파일명 : {}", result);
        log.info("2) 파일사이즈 : {}", result.size());


        return new ResponseEntity<Map<String, Object>>(result, headers, HttpStatus.OK);

    }


//=============================================================================================================


    // 카테고리별 상품 출력
    @GetMapping("/shop/{cateTop}")
    public String itemCate(@PathVariable("cateTop")String cateTop, Model model) {
        List<Item> item = itemService.findByCate(cateTop);
        model.addAttribute("item", item);
        return "/grrreung/sub/shop";
    }

    // (관리자만 가능)상품등록
    @GetMapping("/admin/item")
    public String registerItems() {

        return "/grrreung/sub/admin-item";
    }

    @GetMapping("/admin")
    public String cateName(String cateTop, Model model) {

        List<Category> cateList = itemService.showCateName(cateTop);
        model.addAttribute("cateName", cateList);
        return "/grrreung/sub/admin-item";


    }




}

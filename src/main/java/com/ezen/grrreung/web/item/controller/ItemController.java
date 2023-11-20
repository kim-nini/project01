package com.ezen.grrreung.web.item.controller;

import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.dto.ItemImg;
import com.ezen.grrreung.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;

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

//    @GetMapping("/itemImages/{itemId}")
//    public ResponseEntity<Resource> itemImages(String fileName, @PathVariable("itemId")int itemId, Model model) throws IOException {
//
//        List<ItemImg> imgFiles = itemService.showImageSlide(itemId);
//        log.info("파일명: {}", imgFiles);
//
//        Path path = Paths.get(location + "/" + imgFileName);
//        String contentType = Files.probeContentType(path);
//
//        // 이미지 파일 외에는 모두 다운로드 처리
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
//        Resource resource = new FileSystemResource(path);
//        if(!contentType.startsWith("image")){
//            // 응답 헤더에 파일정보 설정
//            headers.setContentDisposition(
//                    ContentDisposition
//                            .builder("attachment")
//                            .filename(fileName, StandardCharsets.UTF_8).build());
//            resource = new FileSystemResource(path);
//        }
//        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//    }




    // 카테고리별 상품 출력
    @GetMapping("/shop/{cateTop}")
    public String itemCate(@PathVariable("cateTop")String cateTop, Model model) {
        List<Item> item = itemService.findByCate(cateTop);
        model.addAttribute("item", item);
        return "/grrreung/sub/shop";
    }




}

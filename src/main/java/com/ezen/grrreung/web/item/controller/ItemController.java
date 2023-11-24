package com.ezen.grrreung.web.item.controller;

import com.ezen.grrreung.domain.item.dto.*;
import com.ezen.grrreung.domain.item.service.ItemService;
import com.ezen.grrreung.web.common.page.FileStore;
import com.ezen.grrreung.web.common.page.Pagination;
import com.ezen.grrreung.web.common.page.RequestParams;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    private final FileStore fileStore;

    // 홈화면
    @RequestMapping("/")
    public String homeItemList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);
        return "/grrreung/index";
    }

    // shop 상품 전체목록 불러오기
    @GetMapping("/shop")
    public String allItemsList(Model model){
        List<Item> list = itemService.allItems();
        model.addAttribute("item", list);
        RequestParams params = new RequestParams();

        int totalElement = itemService.countByParams(params);
        log.info(" *** 검색 개수 : {} ", totalElement);

        Pagination pagination = new Pagination(params, totalElement);
        log.info(" *** 첫페이지 : {}",pagination.getStartPage());
        log.info(" *** 끝페이지 : {}",pagination.getEndPage());
        log.info(" ***** pagination : {}", pagination);
        model.addAttribute("pagination", pagination);

        return "/grrreung/sub/shop";
    }


    // 상품 검색
    @GetMapping("/search")
    public String searchList(@RequestParam(value="searchValue") String itemName, Model model) {
        RequestParams params = new RequestParams();
        String searchValue = itemName;
        params.setSearch(searchValue);
        log.info(" *** 넘겨받은 search값 : {}", searchValue);

        List<Item> searchList =  itemService.searchItem(params);
        model.addAttribute("item", searchList);
        log.info(" *** 검색 목록 : {}", searchList);

        int totalElement = itemService.countByParams(params);
        log.info(" *** 검색 개수 : {} ", totalElement);

        Pagination pagination = new Pagination(params, totalElement);
        log.info(" *** 첫페이지 : {}",pagination.getStartPage());
        log.info(" *** 끝페이지 : {}",pagination.getEndPage());
        log.info(" ***** pagination : {}", pagination);
        model.addAttribute("pagination", pagination);

        return "/grrreung/sub/shop";
    }


    // 아이템 아이디로 상품 한개 상세정보
    @RequestMapping("/shop/item/{itemId}")
    public String itemInfo(@PathVariable("itemId")int itemId, Model model){
        Item item = itemService.findByItemId(itemId);
        // 슬라이드 상품이미지 가져오기
        List<Map<String, Object>> imgFiles = itemService.showImageSlide(itemId);
        // 상품 정보 이미지 가져오기
        List<Map<String, Object>> itemDescription = itemService.showDescriptionImages(itemId);

        model.addAttribute("item", item);
        model.addAttribute("imgFiles", imgFiles);
        model.addAttribute("itemDescription", itemDescription);
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

    //  이미지 1개 불러오기 => 보여주기
    @GetMapping("/img/{imgName}")
    public ResponseEntity<Resource> imageRender(@PathVariable("imgName") String imgName, Model model) throws IOException {

        Path path = Paths.get(location + "/" + imgName);
		String contentType = Files.probeContentType(path);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new FileSystemResource(path);
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

//=============================================================================================================

    // 이미지 슬라이드
    @GetMapping("/itemInfoImage/{itemId}")
    public ResponseEntity<Map<String, Object>> itemDescriptionImages(@PathVariable("itemId")int itemId, Model model) throws IOException {
        List<Map<String, Object>> itemDescription = itemService.showDescriptionImages(itemId); // 상품 상세정보 - 상품 상세정보 이미지

        String imageDescription = "";
        Resource resource = null;
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> result = new HashMap<>();

        for(Map<String, Object>  map : itemDescription) {
            imageDescription = (String) map.get("IMG_NAME");
            log.info("1)파일명 : {}", imageDescription);
            Path path = Paths.get(location + "/" + imageDescription);

            String contentType = Files.probeContentType(path);
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);
            resource = new FileSystemResource(path);
        }
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
// ===================================================================================================
    // 상위 카테고리 이름 DB에서 찾아오기
    @RequestMapping("/admin")
    public String searchCategory(Model model) {
        List<Category> cateList = itemService.categoryAllList();
        model.addAttribute("cateList", cateList);
//        log.info("{}", cateList);
        return "/grrreung/sub/admin-item";
    }

    // 상세 카테고리 불러오기
    @GetMapping("/sub-category")
    @ResponseBody
    public List<Category> searchDetailCategory(@RequestParam String category, Model model) {
        log.info("수신한 메인카테고리 : {}", category);
        List<Category> subCateList = itemService.showCateName(category);
        log.info("검색한 상세 카테고리 : {}", subCateList);
        return subCateList;
    }

//==============================================================================================

    // 관리자 권한으로 아이템 등록하기

    @PostMapping("/register-item")
    public String  registerItem(@ModelAttribute Item item, @RequestParam int cateCode, @ModelAttribute UploadForm uploadForm, RedirectAttributes redirectAttributes)
            throws IOException {

        log.info("수신정보:{}", item.toString());
        item.setCateCode(cateCode);
        itemService.registerItem(item);
        // 카테고리 선택한정보로 value값으로 카테고리 코드 cateCode 받아오기

        log.info("업로드 파일: {}", uploadForm.getUploadfiles());

        // 업로드 파일들 저장
        List<UploadFile> uploadFiles = fileStore.storeFiles(uploadForm.getUploadfiles());
        log.info("저장된 파일명 : {}", uploadFiles);

        // DB 테이블에 업로드 파일과 저장된 파일명 저장 후

        for(UploadFile uploadFile: uploadFiles) {
            ItemImg itemImg = new ItemImg(item.getItemId(), uploadFile.getUploadFileName(), uploadFile.getStoreFileName());
//            itemImg.setItemId(item.getItemId());
//            itemImg.setImgName(uploadFile.getUploadFileName());
//            itemImg.setOriImgName(uploadFile.getStoreFileName());
            log.info("업로드 파일정보 : {}", uploadFile);
            itemService.uploadItemimg(itemImg);
        }

        // 업로드 파일 저장 후
        // 데이터베이스 테이블에 업로드 파일명과 실제 저장파일명을 저장(테이블의 컬럼이 2개 필요)

        return "redirect:/grrreung/admin";
    }


    @RequestMapping ("/update-item")
    public String registerItem(Model model) {
        List<Category> cateList = itemService.categoryAllList();
        model.addAttribute("cateList", cateList);


        Map<String, Object> map = itemService.updateInfo(1);
        model.addAttribute("item", map);

        return "/grrreung/sub/admin-item-update";

    }
//==============================================================================================








//    @GetMapping("/order")
//    public String orderSheet() {
//        return "/grrreung/sub/order-sheet";
//    }





}

package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.service.ItemRevService;
import com.ezen.grrreung.web.common.Pagination;
import com.ezen.grrreung.web.common.RequestParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/grrreung/itemrev")
@RequiredArgsConstructor
@Controller
@Slf4j
public class ItemRevController {

    // 비지니스로직을 제공하는 객체생성
    private final ItemRevService itemRevService;

    // itemRev 전체 목록
    @GetMapping(value = {"myreview/{memberId}",""})
//    @GetMapping()
    public String postList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "search", required = false, defaultValue = "") String search,
                           @PathVariable(required = false) String memberId,
                           Model model){
        // 페이징 처리와 관련된 변수
        int elementSize = 5; // 화면에 보여지는 행의 갯수
        int pageSize = 3;     // 화면에 보여지는 페이지 갯수

        // 나의 후기 클릭시
        if (memberId != null && search.isEmpty()) {
            search = memberId;
        }

        log.info("받아온 아이디 : {}", memberId);
        // 여러개의 요청 파라메터 정보 저장
        RequestParams params = new RequestParams(page, elementSize, pageSize, search);

        // 페이징처리 값 테이블의 전체 갯수
        int selectCount = itemRevService.postListCount(params);

        // params : 사용자가 선택한 페이지번호 , 검색값 여부
        // 페이징 처리 계산 유틸리티 활용
        Pagination pagination = new Pagination(params, selectCount);
        if (pagination.getEndPage() == 0) {
            pagination.setEndPage(1);
        }
        List<ItemRev> list = itemRevService.postList(params);



        model.addAttribute("params", params); // 요청 파라메터
        model.addAttribute("pagination", pagination); // 페이징 계산 결과
        model.addAttribute("list",list); // db 리스트

        return "/grrreung/sub/review";
    }

    
//    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
//    @GetMapping("/create/{itemName}/{orderId}")
//    public ResponseEntity<Map<String, String>> form(@PathVariable String itemName, @PathVariable int orderId, Model model){
//
//        // member_id 세션에서 받아오기 (가정)
//        String memberId = "customer1";
//
//        // 이미 작성한 게시물에대한 처리
//        // 상품명으로 상품id 가져오기
//        int itemId = itemRevService.getItemId(itemName);
//
//        //memberid와 itemId, order_id로 count해서 중복등록 방지하기
//        // 동일한 order_id,item_id,member_id로 구매한 수량 보다
//        // 동일한 member_id,item_id로 작성된 게시글이 더 적을 때만 게시글작성가능
//        // else 일경우 작성이 완료됨을 알리고 수정여부를 묻기
//        Map<String, Object> map = new HashMap<>();
//        map.put("memberId", memberId);
//        map.put("orderId", orderId);
//        map.put("itemId", itemId);
//        // 구매수량
//        int countPurchases = itemRevService.numberOfPurchases(map);
//        // 작성된 게시글 수
//        ItemRev forCheck = new ItemRev();
//        forCheck.setMemberId(memberId);
//        forCheck.setItemId(itemId);
//        int writtenPost = itemRevService.writtenPost(forCheck);
//        writtenPost=100;
////        if (writtenPost>=countPurchases){
////            Map<String, String> result = new HashMap<>();
////            result.put("message", "알림 메시지");
////            return ResponseEntity.ok(result);
////
////        }
//        Map<String, String> response = new HashMap<>();
//        if (writtenPost>=countPurchases) {
//            response.put("status", "success");
//        } else {
//            response.put("status", "notWritten");
//        }
//
//        return ResponseEntity.ok(response);
//    }
//
//
//
//    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
//    @GetMapping("/create/{itemName}")
//    public String form(@PathVariable String itemName, Model model){
//
//
//        return "/grrreung/sub/rev-write";
//    }


    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
    @GetMapping("/create/{itemName}/{orderId}")
    public String form(@PathVariable String itemName, @PathVariable int orderId, Model model){

        // member_id 세션에서 받아오기 (가정)
        String memberId = "customer1";

        // 이미 작성한 게시물에대한 처리
        // 상품명으로 상품id 가져오기
        int itemId = itemRevService.getItemId(itemName);

        //memberid와 itemId, order_id로 count해서 중복등록 방지하기
        // 동일한 order_id,item_id,member_id로 구매한 수량 보다
        // 동일한 member_id,item_id로 작성된 게시글이 더 적을 때만 게시글작성가능
        // else 일경우 작성이 완료됨을 알리고 수정여부를 묻기
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("orderId", orderId);
        map.put("itemId", itemId);
        // 구매수량
        int countPurchases = itemRevService.numberOfPurchases(map);
        // 작성된 게시글 수
        ItemRev forCheck = new ItemRev();
        forCheck.setMemberId(memberId);
        forCheck.setItemId(itemId);
        int writtenPost = itemRevService.writtenPost(forCheck);
        writtenPost=100;
//        if (writtenPost>=countPurchases){      }

        return "/grrreung/sub/rev-write";
    }




    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping("/create")
    public String posting(@ModelAttribute("itemRev") ItemRev itemRev, @ModelAttribute("itemName") String itemName){

        // member_id 세션에서 받아오기 (가정)
        itemRev.setMemberId("customer1");

        // 상품명으로 상품id 가져오기
        int itemId = itemRevService.getItemId(itemName);
        itemRev.setItemId(itemId);

        itemRevService.posting(itemRev);
        return "redirect:/itemrev";
    }

    // 상세보기 겟매핑
    @GetMapping("/{revCode}")
    public String postInfo(@PathVariable int revCode, Model model){
        ItemRev itemRevInfo = itemRevService.postInfo(revCode);
        model.addAttribute("itemRev",itemRevInfo);
        return "/grrreung/sub/rev-cont";
    }


    

}

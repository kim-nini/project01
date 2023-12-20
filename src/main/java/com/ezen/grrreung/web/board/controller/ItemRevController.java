package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.service.ItemRevService;
import com.ezen.grrreung.domain.item.service.ItemService;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.web.common.Pagination;
import com.ezen.grrreung.web.common.RequestParams;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/grrreung/itemrev")
@RequiredArgsConstructor
@Controller
@Slf4j
public class ItemRevController {

    // 이미지 경로
    @Value("${file.dir}")
    private String location;

    // 비지니스로직을 제공하는 객체생성
    private final ItemRevService itemRevService;
    private final ItemService itemService;

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
        if (memberId != null ) {
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
//    @GetMapping("/create")
//    public String form(){
//        return "/grrreung/sub/rev-write";
//    }

    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
    @GetMapping("/create/{itemId}/{orderId}")
    public String form(@PathVariable int itemId, @PathVariable int orderId, HttpServletRequest request, Model model) throws IOException {
        //세션에서 memberId 가져오기
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("loginMember");
        String memberId = member.getMemberId();
        log.info("멤버아이디 : {}",member);

        log.info("itemid : {}",itemId);



        // memberid와 itemId, order_id로 count해서 중복등록 방지하기
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

        // 작성된 게시글 수가 구매 수량보다 많거나 같을경우
        if (writtenPost>=countPurchases){
            return "/grrreung/sub/mypage";
        }



        return "/grrreung/sub/rev-write";
    }


    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping("/create/{itemId}/{orderId}")
    public String posting(@ModelAttribute("itemRev") ItemRev itemRev, HttpServletRequest request, Model model) {
        //세션에서 memberId 가져오기
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("loginMember");
        String memberId = member.getMemberId();

        // memberId 객체에 담아주기
        itemRev.setMemberId(memberId);

        itemRevService.posting(itemRev);
        return "redirect:/grrreung/itemrev";
    }

    // 상세보기 겟매핑
    @GetMapping("/{revCode}")
    public String postInfo(@PathVariable int revCode, Model model) {
        ItemRev itemRevInfo = itemRevService.postInfo(revCode);
        model.addAttribute("itemRev", itemRevInfo);
        return "/grrreung/sub/rev-cont";
    }

    // 수정하기 겟매핑
    @GetMapping("/update/{revCode}")
    public String postView(@PathVariable int revCode, Model model){
        ItemRev itemRevInfo = itemRevService.postInfo(revCode);
        model.addAttribute("itemRev", itemRevInfo);

        return "/grrreung/sub/rev-update";
    }

    // 포스트매핑 -> 수정버튼
    @PostMapping("/update/{revCode}")
    public String postUpdate(@ModelAttribute("itemRev") ItemRev itemRev){
        itemRevService.updatePost(itemRev);
        return "redirect:/grrreung/itemrev";
    }

    @GetMapping("/delete/{revCode}")
    public String delete(@PathVariable int revCode, Model model){
        itemRevService.deletePost(revCode);
        return "redirect:/grrreung/itemrev";
    }

}

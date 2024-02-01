package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemQnaRe;
import com.ezen.grrreung.domain.board.service.ItemQnaService;
import com.ezen.grrreung.domain.item.dto.Category;
import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.service.ItemService;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.web.common.Pagination;
import com.ezen.grrreung.web.common.RequestParams;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/itemqna")
@RequiredArgsConstructor
@Controller
@Slf4j
public class ItemQnaController {

    // 비지니스로직을 제공하는 객체생성
    private final ItemQnaService itemQnaService;
    private final ItemService itemService;

    // itemQna 전체 목록
    @GetMapping()
    public String postList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "search", required = false, defaultValue = "") String search,
                           Model model) {
        // 페이징 처리와 관련된 변수
        int elementSize = 8; // 화면에 보여지는 행의 갯수
        int pageSize = 5;     // 화면에 보여지는 페이지 갯수


        // 여러개의 요청 파라메터 정보 저장
        RequestParams params = new RequestParams(page, elementSize, pageSize, search);

        // 페이징처리 값 테이블의 전체 갯수
        int selectCount = itemQnaService.postListCount(params);

        // params : 사용자가 선택한 페이지번호 , 검색값 여부
        // 페이징 처리 계산 유틸리티 활용
        Pagination pagination = new Pagination(params, selectCount);
        if (pagination.getEndPage() == 0) {
            pagination.setEndPage(1);
        }

        List<ItemQna> list = itemQnaService.postList(params);

        for (ItemQna item : list) {
            int qnaCode = item.getQnaCode();
            if (!itemQnaService.getListByQnaCode(qnaCode).isEmpty()) {
                item.setHasRe(true);
            }
        }


        model.addAttribute("params", params); // 요청 파라메터
        model.addAttribute("pagination", pagination); // 페이징 계산 결과
        model.addAttribute("list", list); // db 리스트

        return "grrreung/sub/qna";
    }


    // qna게시판에서 겟매핑 -> 게시글 작성 화면으로 넘어감
    @GetMapping("/create" )
    public String form( Model model) {

        List<Category> cateList = itemService.categoryAllList();
        model.addAttribute("cateList", cateList);
        return "grrreung/sub/qna-write";
    }

    // 상품상세정보에서 겟매핑 -> 게시글 작성 화면으로 넘어감
    @GetMapping("/create/{itemId}")
    public String form(@PathVariable(value = "itemId",required = false) int itemId,  Model model) {

        // itemId로 item 가져오기
        Item item = itemService.findByItemId(itemId);
        model.addAttribute("item", item);

        log.info("게시글작성 item {}", itemId);

        List<Category> cateList = itemService.categoryAllList();
        model.addAttribute("cateList", cateList);
        return "grrreung/sub/qna-write";
    }

    // 포스트 매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping(value = {"/create", "/create/{itemId}"})
    public String posting(@PathVariable(value = "itemId",required = false) Integer itemId, @ModelAttribute("itemQna") ItemQna itemQna, HttpSession session) {
        //세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();
        itemQna.setMemberId(memberId);

        log.info("게시글작성 itemId {}", itemQna.getItemId());
        log.info("게시판에서 가져온 ID값 {}", itemId);
        if(itemId != null){
            itemQna.setItemId(itemId);
            itemQnaService.posting(itemQna);
            return "redirect:/shop/item/"+itemId;
        }
        itemQnaService.posting(itemQna);
        return "redirect:/itemqna";
    }

    // 상세보기 겟매핑
    @GetMapping("/{qnaCode}")
    public String postInfo(@PathVariable int qnaCode, Model model) {
        // ItemQna 데이터 가져오기
        ItemQna itemQnaInfo = itemQnaService.postInfo(qnaCode);
        model.addAttribute("itemQna", itemQnaInfo);

        // ItemQnaRe 데이터 가져오기
        List<ItemQnaRe> list = itemQnaService.getListByQnaCode(qnaCode);
        model.addAttribute("qnaReList", list);

        return "grrreung/sub/qna-cont";
    }

    // 수정하기 겟매핑
    @GetMapping("/update/{qnaCode}")
    public String postView(@PathVariable int qnaCode, Model model) {
        ItemQna itemQnaInfo = itemQnaService.postInfo(qnaCode);
        model.addAttribute("itemQna", itemQnaInfo);

        return "grrreung/sub/qna-update";
    }

    // 포스트매핑 -> 수정버튼
    @PostMapping("/update/{qnaCode}")
    public String postUpdate(@ModelAttribute("itemQna") ItemQna itemQna) {
        itemQnaService.updatePost(itemQna);
        return "redirect:/itemqna";
    }

    // 겟매핑 -> 삭제버튼
    @GetMapping("/delete/{qnaCode}")
    public String delete(@PathVariable int qnaCode, Model model) {
        itemQnaService.deletePost(qnaCode);
        return "redirect:/itemqna";
    }

    //----------- 문의 답변 --------------------------

    // qna 답변 등록하기
    @GetMapping("/re-create")
    public ResponseEntity<ItemQnaRe> reCreate(@RequestParam String reCont, @RequestParam int qnaCode) {

        // 요청파라미터가 적용된 dto 생성
        ItemQnaRe itemQnaRe = new ItemQnaRe();
        itemQnaRe.setQnaCode(qnaCode);
        itemQnaRe.setReCont(reCont);

        // qna 답변 db에 등록 후 시퀀스로 생성된 reCode받아오기
        int reCode = itemQnaService.postRe(itemQnaRe);

        // 받아온 reCode로 db에 등록된 itemQnaRe 데이터 가져오기
        itemQnaRe = itemQnaService.getReByReCode(reCode);


        return new ResponseEntity<>(itemQnaRe, HttpStatus.OK);
    }


    // qna 답변 수정하기
    @GetMapping("/re-update")
    public ResponseEntity<ItemQnaRe> reUpdate(@RequestParam String reCont, @RequestParam int reCode, @RequestParam int qnaCode) {
        // 요청파라미터가 적용된 dto 생성
        ItemQnaRe itemQnaRe = new ItemQnaRe();
        itemQnaRe.setQnaCode(qnaCode);
        itemQnaRe.setReCont(reCont);
        itemQnaRe.setReCode(reCode);

        // db 내용 수정
        itemQnaService.updateQnaRe(itemQnaRe);


        // 수정된 itemQnRe 가져오기
        itemQnaRe = itemQnaService.getReByReCode(reCode);


        return new ResponseEntity<>(itemQnaRe, HttpStatus.OK);
    }

    // qna 답변 삭제하기
    @GetMapping("/re-delete")
    public ResponseEntity<ItemQnaRe> reDelete(@RequestParam int reCode, @RequestParam int qnaCode) {
        itemQnaService.deleteQnaRe(reCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // 아이템 상세보기 페이지에 보여줄 상품문의 목록 조회
    @ResponseBody
    @RequestMapping("/all-qna")
    public List<ItemQna> findItemQna(@RequestParam int itemId, Model model, HttpSession session) {


        List<ItemQna> list = itemQnaService.itemQnaAll(itemId);

        // 상품문의 답변 유무
        for (ItemQna qna : list) {

            int qnaCode = qna.getQnaCode();

            if (session.getAttribute("loginMember") != null) {
                //세션에서 memberId 가져오기
                Member member = (Member) session.getAttribute("loginMember");
                qna.setMember(member);
            }

            // 답변이 있다면 true
            if (!itemQnaService.getListByQnaCode(qnaCode).isEmpty()) {
                qna.setQnaRes(itemQnaService.getListByQnaCode(qnaCode));
                qna.setHasRe(true);
            }

        }


        return list;
    }


    // 아이템 상세보기 페이지에 보여줄 상품문의 목록 조회
    @ResponseBody
    @RequestMapping("/qnaRe")
    public List<ItemQnaRe> findQnaRe(@RequestParam int qnaCode, Model model) {
        // ItemQnaRe 데이터 가져오기
        List<ItemQnaRe> list = itemQnaService.getListByQnaCode(qnaCode);
//        model.addAttribute("qnaReList", list);

        return list;
    }

}

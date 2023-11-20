package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.service.NoticeService;
import com.ezen.grrreung.web.common.Pagination;
import com.ezen.grrreung.web.common.RequestParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/notice")
@RequiredArgsConstructor
@Controller
public class NoticeController {

    // 비지니스로직을 제공하는 객체생성
    private final NoticeService noticeService;

    // notice 전체 목록
    @GetMapping("")
    public String postList(@RequestParam(value = "page",  required = false, defaultValue = "1") int page,
                           @RequestParam(value = "search", required = false, defaultValue = "") String search,
                           Model model){
        // 페이징 처리와 관련된 변수
        int requestPage = 1;  // 사용자 요청 페이지
        int elementSize = 10; // 화면에 보여지는 행의 갯수
        int pageSize = 5;     // 화면에 보여지는 페이지 갯수

        // 여러개의 요청 파라메터 정보 저장
        RequestParams params = new RequestParams(page, elementSize, pageSize, search);

        // 요청 파라메터에 해당하는 회원 목록 조회
//        List<Member> list = memberService.getMembers(params);

        // 페이징처리 값 테이블의 전체 갯수
//        int selectCount = memberService.getMemberCount(params);

        // params : 사용자가 선택한 페이지번호 , 검색값 여부
        // 페이징 처리 계산 유틸리티 활용
//        Pagination pagination = new Pagination(params, selectCount);

        // 모델에 데이터 저장
        // 사용자가 선택한 번호
        model.addAttribute("params", params);
        // db내용 출력할 테이블 컬럼(행)
//        model.addAttribute("list", list);
        // 페이지내이션 -> 계산해서
//        model.addAttribute("pagination", pagination);


//        map.put("params", params);         // 요청 파라메터
//        map.put("list", list);             // 검색 목록
//        map.put("pagination", pagination); // 페이징 계산 결과
//        model.put("page", map);

//        return viewName;



        List<Notice> list = noticeService.postList();


        model.addAttribute("list",list);
        return "/grrreung/sub/notice";
    }

    // 포스트 매핑 -> 게시글 검색
    @PostMapping("/list")
    public String searchList(@ModelAttribute("searchValue")String searchValue, Model model){
        List<Notice> list = noticeService.searchList(searchValue);
        model.addAttribute("list",list);
        return "/grrreung/sub/notice";
    }

    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
    @GetMapping("/create")
    public String form(){
        return "/grrreung/sub/notice-write";
    }

    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping("/create")
    public String posting(@ModelAttribute("notice")Notice notice){
        noticeService.posting(notice);
        return "redirect:/notice";
    }

    // 상세보기 겟매핑
    @GetMapping("/{notiCode}")
    public String postInfo(@PathVariable int notiCode, Model model){
        Notice noticeInfo = noticeService.postInfo(notiCode);
        model.addAttribute("notice",noticeInfo);
        return "/grrreung/sub/notice-cont";
    }



}

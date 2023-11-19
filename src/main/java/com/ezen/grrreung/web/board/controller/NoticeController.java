package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/notice")
@Controller
public class NoticeController {

    // 비지니스로직을 제공하는 객체생성
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
//    @GetMapping("/create")
//    public String form(){
//        return "//create";
//    }

    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
//    @PostMapping("/create")
//    public String posting(@ModelAttribute("board") Notice notice){
//        boardService.posting(notice);
//        return "redirect:/board/list";
//    }

    // 겟 매핑 -> 게시글 목록
    @GetMapping("/list")
    public String postList(Model model){
        List<Notice> list = noticeService.postList();
        model.addAttribute("list",list);
        return "/grrreung/sub/notice";
    }

}

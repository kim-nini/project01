package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.service.ItemQnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/itemqna")
@RequiredArgsConstructor
@Controller
public class ItemQnaController {

    // 비지니스로직을 제공하는 객체생성
    private final ItemQnaService itemQnaService;

   //  게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
    @GetMapping("/create")
    public String form(){
        return "/grrreung/sub/post";
    }

    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping("/create")
    public String posting(@ModelAttribute("itemQna")ItemQna itemQna){
        itemQnaService.posting(itemQna);
        return "redirect:/itemqna/list";
    }

    // 겟 매핑 -> 게시글 목록
    @GetMapping("/list")
    public String postList(Model model){
        List<ItemQna> list = itemQnaService.postList();
        model.addAttribute("list",list);
        return "/grrreung/sub/qna";
    }

    // 포스트 매핑 -> 게시글 검색
    @PostMapping("/list")
    public String searchList(@ModelAttribute("searchValue")String searchValue, Model model){
        List<ItemQna> list = itemQnaService.searchList(searchValue);
        model.addAttribute("list",list);
        return "/grrreung/sub/qna";
    }

    // 겟 매핑 -> 게시글 상세보기





}

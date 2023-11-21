package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemQna;
import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.dto.Notice;
import com.ezen.grrreung.domain.board.service.ItemRevService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/itemrev")
@RequiredArgsConstructor
@Controller
public class ItemRevController {

    // 비지니스로직을 제공하는 객체생성
    private final ItemRevService itemRevService;

    // itemrev 게시글 목록
    @GetMapping("")
    public String postList(Model model){
        List<ItemRev> list = itemRevService.postList();
        model.addAttribute("list",list);
        return "/grrreung/sub/review";
    }

    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
    @GetMapping("/create")
    public String form(){ return "/grrreung/sub/rev-write"; }

    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
    @PostMapping("/create")
    public String posting(@ModelAttribute("itemRev") ItemRev itemRev){
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

    // 포스트 매핑 -> 게시글 검색
    @PostMapping("/list")
    public String searchList(@ModelAttribute("searchValue")String searchValue, Model model){
        List<ItemRev> list = itemRevService.searchList(searchValue);
        model.addAttribute("list",list);
        return "/grrreung/sub/review";
    }
    

}

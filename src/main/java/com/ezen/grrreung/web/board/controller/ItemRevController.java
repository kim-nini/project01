package com.ezen.grrreung.web.board.controller;

import com.ezen.grrreung.domain.board.dto.ItemRev;
import com.ezen.grrreung.domain.board.service.ItemRevService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/itemrev")
@Controller
public class ItemRevController {

    // 비지니스로직을 제공하는 객체생성
    private final ItemRevService itemRevService;

    public ItemRevController(ItemRevService itemRevService) {
        this.itemRevService = itemRevService;
    }

    // 게시글 등록 겟매핑 -> 게시글 등록 화면으로 넘어감
//    @GetMapping("/create")
//    public String form(){
//        return "//create";
//    }

    // 포스트매핑 -> 게시글 등록에서 submit 버튼 클릭시 작동 -> 리스트화면으로 넘어감
//    @PostMapping("/create")
//    public String posting(@ModelAttribute("board") ItemRev itemRev){
//        boardService.posting(itemRev);
//        return "redirect:/board/list";
//    }

    // 겟 매핑 -> 게시글 목록
    @GetMapping("/list")
    public String postList(Model model){
        List<ItemRev> list = itemRevService.postList();
        model.addAttribute("list",list);
        return "/grrreung/sub/review";
    }

}

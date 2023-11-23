package com.ezen.grrreung.web.cart.controller;

import com.ezen.grrreung.domain.member.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grrreung")
@RequiredArgsConstructor
@SessionAttributes
@Slf4j
public class CartController {

    private final CartService cartService;

    /**
     * 장바구니 목록 조회
     */
    @GetMapping("/cart/{memberId}")
    public String list(@PathVariable("memberId") String memberId, Model model){
        List<Map<String, Object>> list = cartService.getCartList(memberId);
        //log.info("장바구니 아이템 수: {}", list.size());
        model.addAttribute("list", list);
        return "/grrreung/sub/cart";
    }


}
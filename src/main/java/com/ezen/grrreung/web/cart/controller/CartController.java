package com.ezen.grrreung.web.cart.controller;

import com.ezen.grrreung.domain.cart.service.CartService;
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
        log.info("받아오는 아이디 : {}", memberId);
        List<Map<String, Object>> list = cartService.getCartList(memberId);
        model.addAttribute("list", list);
        return "/grrreung/sub/cart";
    }
}
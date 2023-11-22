package com.ezen.grrreung.web.member.controller;

import com.ezen.grrreung.domain.member.dto.Cart;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.CartService;
import com.ezen.grrreung.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Cart> list = cartService.getCartList(memberId);
        model.addAttribute("list", list);
        return "/grrreung/sub/cart";
    }


}
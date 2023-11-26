package com.ezen.grrreung.web.cart.controller;

import com.ezen.grrreung.domain.cart.dto.Cart;
import com.ezen.grrreung.domain.cart.service.CartService;
import com.ezen.grrreung.domain.item.dto.Item;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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

        for (Map<String, Object> map: list) {
            log.info("**** 카트 정보 확인 : {}", map);
        }

        return "/grrreung/sub/cart";
    }

    // 장바구니 상품 추가
    @PostMapping("/cart/{memberId}")
    public String addToCartItem(@PathVariable("memberId") String memberId,
                              @ModelAttribute Cart cart,@ModelAttribute Item item) {
        int itemId = item.getItemId();

        int cartAmount = cart.getCartAmount();
        log.info("itemId : {}", itemId);
        log.info("memberId : {}", memberId);
        log.info("상품 수량: {}", cartAmount);
        log.info("장바구니 넣기 넘겨받은 정보 : {}", cart);

        // 서버로부터 전송받은 값 Cart객체에 저장
        cart.setMemberId(memberId);
        cart.setItemId(itemId);
        cart.setCartAmount(cartAmount);

        cartService.addToCart(cart);
        return "redirect:/grrreung/cart/{memberId}";
    }

//    @PostMapping("/add-to-cart/{itemId}/{memberId}")
//    public void addToCartItem(@PathVariable("itemId") int itemId,
//                              @PathVariable("memberId") String memberId,
//                              @ModelAttribute Cart cart) {
//
//        int cartAmount = cart.getCartAmount();
//        log.info("itemId : {}", itemId);
//        log.info("memberId : {}", memberId);
//        log.info("상품 수량: {}", cartAmount);
//        log.info("장바구니 넣기 넘겨받은 정보 : {}", cart);
//
//        // 서버로부터 전송받은 값 Cart객체에 저장
//        cart.setMemberId(memberId);
//        cart.setItemId(itemId);
//        cart.setCartAmount(cartAmount);
//
//        cartService.addToCart(cart);
//
//    }
//










}
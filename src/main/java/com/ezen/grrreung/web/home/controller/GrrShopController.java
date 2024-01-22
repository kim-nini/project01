package com.ezen.grrreung.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grrreung")
//@RequiredArgsConstructor
//@Slf4j
public class GrrShopController {

    // 상품 정보 / 상세 페이지 이동
    @RequestMapping("/item")
    public String itemInfo(){
        return "/grrreung/sub/item";
    }


    // FAQ 페이지 이동
    @RequestMapping("/faq")
    public String faq(){
        return "/grrreung/sub/faq";
    }


    // 로그인 페이지 이동
    @RequestMapping("/login")
    public String login(){
        return "/grrreung/sub/login";
    }

    // 회원 가입 페이지 이동
    @RequestMapping("/register")
    public String register(){
        return "/grrreung/sub/register";
    }

    // 마이페이지 이동
    @RequestMapping("/mypage")
    public String mypage(){
        return "/grrreung/sub/mypage";
    }

    // 장바구니 페이지 이동
    @RequestMapping("/cart")
    public String cart(){
        return "/grrreung/sub/cart";
    }


}

package com.ezen.grrreung.web.order.controller;


import com.ezen.grrreung.domain.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderGrController {

    private final OrderService orderService;

//    주문내역조회
//    @GetMapping("/")
    public String orderHistory(){


        return "/grrreung/sub/mypage";
    }


    /**
     * 주문서 작성 화면 요청
     */
//    @GetMapping("/1")
//    public String registerForm(){
//        return "member/1";
//    }


}


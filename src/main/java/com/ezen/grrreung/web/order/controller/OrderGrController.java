package com.ezen.grrreung.web.order.controller;


import com.ezen.grrreung.domain.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderGrController {

    private final OrderService orderService;

//    주문내역조회
    @GetMapping
    @ResponseBody
    public Map<String, Object> orderHistory(@RequestParam String memberId, Model model){
        Map<String, Object> map = orderService.orderHistory(memberId);
       String order_id = "" + map.get("order_id");
        log.info(order_id);

        return map;
    }


    /**
     * 주문서 작성 화면 요청
     */
//    @GetMapping("/1")
//    public String registerForm(){
//        return "member/1";
//    }


}


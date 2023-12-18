package com.ezen.grrreung.web.order.controller;


import com.ezen.grrreung.domain.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public List<Map<String, Object>> orderHistory(@RequestParam String memberId, Model model){
        List<Map<String, Object>> list = orderService.orderHistory(memberId);
//       String order_id = "" + map.get("order_id");
        log.info("리스트크기 : {}",list.size());
//        int index = list.size();
//        boolean writtenPost = true;
//        Map<String, Object> valueMap = new HashMap<>();
//        valueMap.put("writtenPost",writtenPost);
//        list.set(index, valueMap);
//        list.get(index);

//        boolean writtenPost;
//        // 구매수량
//        int countPurchases = 1;
//        // 작성된 게시글 수
//        map.put("writtenPost",writtenPost);

        return list;
    }


    /**
     * 주문서 작성 화면 요청
     */
    @GetMapping("/form")
    public String orderForm(HttpServletRequest request, Model model){
        // 세션에서 memberId 가져오기
        HttpSession session = request.getSession();
        String sessionMemberId = (String) session.getAttribute("memberId");

        return "/grrreung/sub/order-sheet";
    }


}

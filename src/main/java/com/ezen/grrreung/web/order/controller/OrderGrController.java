package com.ezen.grrreung.web.order.controller;


import com.ezen.grrreung.domain.cart.dto.Cart;
import com.ezen.grrreung.domain.cart.service.CartService;
import com.ezen.grrreung.domain.item.service.ItemService;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.MemberService;
import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.order.dto.OrderItem;
import com.ezen.grrreung.domain.order.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderGrController {

    private final OrderService orderService;
    private final ItemService itemService;
    private final CartService cartService;
    private final MemberService memberService;

    //    주문내역조회
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> orderHistory( HttpSession session, Model model) {
        // 세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();

        List<Map<String, Object>> list = orderService.orderHistory(memberId);
//       String order_id = "" + map.get("order_id");
        log.info("리스트크기 : {}", list.size());

//        int index = list.size();
//        boolean writtenPost = true;
//        Map<String, Object> valueMap = new HashMap<>();
//        valueMap.put("writtenPost",writtenPost);
//        list.set(index, valueMap);
//        list.get(index);
//
//        boolean writtenPost;
//        // 구매수량
//        int countPurchases = 1;
//        // 작성된 게시글 수
//        map.put("writtenPost",writtenPost);

        return list;
    }




    // 주문서 작성화면 요청
    @GetMapping("/form")
    public String orderForm(@RequestParam("itemId") List<String> itemId, HttpSession session, Model model) {

        // 세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();

        // 매개변수로 보낼 map 생성
        Map<String,Object> map = new HashMap<>();
        
        // memberId 담기
        map.put("memberId",memberId);

        // List<String>를 List<Integer>로 변환
        List<Integer> integerList = itemId.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        // itemIds 리스트 map에 담기
        map.put("itemIds", integerList);

        // itemId와 memberId로 카트에 담긴 리스트 가져오기
        List<Map<String, Object>> list = cartService.getCheckedList(map);
        model.addAttribute("list", list);

        return "/grrreung/sub/order-sheet";
    }


    // 주문서 작성 post 매핑
    @PostMapping("/form")
    public String orderCompleted(@ModelAttribute OrderGr ordergr, HttpSession session, Model model) {

        // 세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();
        ordergr.setMemberId(memberId);

        // 받아온 orderGr 에서 orderPrice 계산해서 셋팅하기
        int orderPrice = 0;
        List<OrderItem> orderItems = ordergr.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            orderPrice += orderItem.getOrderPrice() * orderItem.getOrderAmount();
        }
        // String 값으로 변경
        ordergr.setOrderPriceAll(orderPrice+"");
        
        // 주문완료 메소드호출
        orderService.orderComplete(ordergr);

        return "/grrreung/sub/order-complete";
    }







}

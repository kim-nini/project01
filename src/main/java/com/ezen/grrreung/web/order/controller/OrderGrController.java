package com.ezen.grrreung.web.order.controller;


import com.ezen.grrreung.domain.board.service.ItemRevService;
import com.ezen.grrreung.domain.cart.dto.Cart;
import com.ezen.grrreung.domain.cart.service.CartService;
import com.ezen.grrreung.domain.item.dto.Item;
import com.ezen.grrreung.domain.item.service.ItemService;
import com.ezen.grrreung.domain.member.dto.Member;
import com.ezen.grrreung.domain.member.service.MemberService;
import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.order.dto.OrderItem;
import com.ezen.grrreung.domain.order.service.OrderService;
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
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderGrController {

    private final OrderService orderService;
    private final ItemService itemService;
    private final ItemRevService itemRevService;
    private final CartService cartService;
    private final MemberService memberService;

    //주문내역조회
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> orderHistory(HttpSession session, Model model) {

        // 세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();

        // 주문내역 데이터 불러오기
        List<Map<String, Object>> list = orderService.orderHistory(memberId);


        // memberid와 itemId, order_id로 count해서 중복등록 방지하기
        // 동일한 order_id,item_id,member_id로 구매한 수량 보다
        // 동일한 member_id,item_id로 작성된 게시글이 더 적을 때만 게시글작성가능

        // 후기작성 버튼 컨트롤
        int count = 0;   // 구매수량
        int writtenCount = 0;    // 작성한 후기 갯수
        boolean writtenPost = true;     // 후기작성여부

        Map<String, Object> checkMap = new HashMap<>();    // 작성된 후기 갯수 조회할 매개변수
        checkMap.put("memberId", memberId); // id 담기

        for (Map<String, Object> map : list) {
            // 구매수량 담기
            count = Integer.parseInt(map.get("order_amount").toString());
            log.info("구매수량 : {}", count);
            // 주문아이디
            checkMap.put("orderId", map.get("order_id"));
            // 아이템아이디
            checkMap.put("itemId", map.get("item_id"));
            log.info("orderId : {}", checkMap.get("orderId"));
            log.info("itemId : {}", checkMap.get("itemId"));

            // 작성된 게시글 수 가져오기
            writtenCount = itemRevService.writtenPost(checkMap);
            log.info("작성된 게시글 수 : {}", writtenCount);
            // 작성된 게시글이 구매수량과 같거나 많을경우
            if (writtenCount >= count) {
                // 후기작성여부 false(후기작성함)
                writtenPost = false;
            } else {
                // 후기작성여부 true(후기작성안함)
                writtenPost = true;
            }
            // 내보낼 list에 후기작성여부 담기
            map.put("writtenPost", writtenPost);
            log.info("map.boolean : {}", map.get("writtenPost"));
        }

        return list;
    }


    // 주문서 작성화면 요청
    @GetMapping("/form")
    public String orderForm(@RequestParam("itemId") List<Integer> itemId, HttpSession session, Model model, HttpServletRequest request, @ModelAttribute Cart cart) {

        // Referer 가져오기
        String referer = request.getHeader("referer");
        log.info("referer {}", referer);

        // 세션에서 memberId 가져오기
        Member member = (Member) session.getAttribute("loginMember");
        String memberId = member.getMemberId();

        // 매개변수로 보낼 map 생성
        Map<String, Object> map = new HashMap<>();

        // memberId 담기
        map.put("memberId", memberId);

        // itemIds 리스트 map에 담기
        map.put("itemIds", itemId);

        // 호출된 곳에 따라 로직 분기
        // cart 에서 구매하기버튼 클릭 시
        if (referer.contains("cart")) {
            // itemId와 memberId로 카트에 담긴 리스트 가져오기
            List<Map<String, Object>> list = cartService.getCheckedList(map);
            model.addAttribute("list", list);
            log.info("카트리스트 {}", list);

            // 총결제금액 계산하기
            int totalPrice = 0;
            for (Map<String, Object> item : list) {
                // int타입으로 변환
                int itemPrice = (int) item.get("item_price");
                int cartAmount = (int) item.get("cart_amount");

                totalPrice += itemPrice * cartAmount;
                log.info("itemPrice {}", itemPrice);
            }

            log.info("totalPrice {}", totalPrice);
            model.addAttribute("totalPrice", totalPrice);

        } else { // 상품페이지에서 바로구매버튼 클릭 시

            Item item = itemService.findByItemId(itemId.get(0));

            int itemPrice = item.getItemPrice(); // 아이템가격
            int cartAmount = cart.getCartAmount();  // 상품 수량
            int totalPrice = itemPrice * cartAmount;    // 총금액
            model.addAttribute("totalPrice", totalPrice);

            // 수동으로 맵에 담아주기
            map.put("item_detail", item.getItemDetail());
            map.put("item_img", itemService.showThumbnail(item.getItemId()));
            map.put("item_id", item.getItemId());
            map.put("item_price", itemPrice);
            map.put("cart_amount", cartAmount);
            map.put("item_name", item.getItemName());

            List<Map<String, Object>> list = new ArrayList<>();
            list.add(map);

            // 바로구매용 list 내보내기
            model.addAttribute("list", list);

        }

        return "grrreung/sub/order-sheet";


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
        int itemId = 0;
        List<OrderItem> orderItems = ordergr.getOrderItems();
        for (OrderItem orderItem : orderItems) {

            // item id 가져오기
            itemId = orderItem.getItemId();
            // 주문한 상품 cart에서 삭제
            cartService.removeCartOne(memberId, itemId);

            orderPrice += orderItem.getOrderPrice();
        }

        // String 값으로 변경
        ordergr.setOrderPriceAll(orderPrice + "");
        log.info("orderPriceAll => {}", orderPrice);
        // 주문완료 메소드호출 
        orderService.orderComplete(ordergr);

        return "grrreung/sub/order-complete";
    }


}

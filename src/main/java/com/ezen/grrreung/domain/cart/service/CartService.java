package com.ezen.grrreung.domain.cart.service;

import com.ezen.grrreung.domain.cart.dto.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CartService {

    // 장바구니 상품 리스트
    public List<Map<String, Object>> getCartList(String memberId);

    // 장바구니 상품 추가하기
    public void addToCart(Cart cart);

    // 장바구니에 같은 ITEM_ID 가 존재할 경우 , 장바구니에 담긴 수량만 증가
    public void updateRegisteredAmount(Cart cart);

    // 장바구니에 담긴 아이템 중복값 확인
    public List<Integer> itemIdDuplication(String memberId);

    // 장바구니 수량 증가
    public void cartAmountPlus(int cartId);

    // 장바구니 수량 감소
    public void cartAmountMinus(int cartId);





}

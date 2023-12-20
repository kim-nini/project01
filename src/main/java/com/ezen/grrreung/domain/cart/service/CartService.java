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

    // 장바구니 수량 증가
    public void cartAmountPlus(String memberId, int itemId);

    // 장바구니 수량 감소
    public void cartAmountMinus(String memberId, int itemId);





}

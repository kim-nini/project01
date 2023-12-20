package com.ezen.grrreung.domain.cart.service;

import com.ezen.grrreung.domain.cart.dto.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {

    // 장바구니 상품 리스트
    public List<Map<String, Object>> getCartList(String memberId);

    // 장바구니 상품 추가하기
    public void addToCart(Cart cart);

    // 선택된 장바구니 상품 리스트
    public List<Map<String, Object>> getCheckedList(Map<String, Object> map);
}

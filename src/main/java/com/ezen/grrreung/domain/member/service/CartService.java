package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.dto.Cart;

import java.util.List;

public interface CartService {

    // 장바구니 상품 리스트
    public List<Cart> getCartList(String memberId);

}

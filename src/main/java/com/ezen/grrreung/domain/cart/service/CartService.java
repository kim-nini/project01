package com.ezen.grrreung.domain.member.service;

import java.util.List;
import java.util.Map;

public interface CartService {

    // 장바구니 상품 리스트
    public List<Map<String, Object>> getCartList(String memberId);

}

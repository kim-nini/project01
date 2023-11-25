package com.ezen.grrreung.domain.cart.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    /**
     * 장바구니 상품 리스트
     */
    public List<Map<String, Object>> findById(String memberId);




}
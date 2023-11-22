package com.ezen.grrreung.domain.member.mapper;

import com.ezen.grrreung.domain.member.dto.Cart;
import com.ezen.grrreung.domain.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    /**
     * 장바구니 상품 리스트
     */
    public List<Cart> findById(String memberId);




}
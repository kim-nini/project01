package com.ezen.grrreung.domain.member.service;

import com.ezen.grrreung.domain.member.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;


    @Override
    public List<Map<String, Object>> getCartList(String memberId) {
        return cartMapper.findById(memberId);
    }
}

package com.ezen.grrreung;

import com.ezen.grrreung.domain.member.dto.Cart;
import com.ezen.grrreung.domain.member.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class CartMapperTest {
	
	@Autowired
	private CartMapper cartMapper;

	@Test
	void cartByIdTest() {
		List<Cart> list = cartMapper.findById("ddalang");
		for(Cart cart : list){
			log.info("장바구니 상품 목록 : {}", cart);
		}
	}
}

package com.ezen.grrreung;

import com.ezen.grrreung.domain.member.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
@Slf4j
public class CartMapperTest {
	
	@Autowired
	private CartMapper cartMapper;

	@Test
	void cartByIdTest() {
		List<Map<String, Object>> list = cartMapper.findById("ddalang");
		for(Map map : list){
			log.info("장바구니 상품 목록 : {}", map);
		}
	}
}

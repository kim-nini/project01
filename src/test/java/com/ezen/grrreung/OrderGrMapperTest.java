package com.ezen.grrreung;


import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.order.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OrderGrMapperTest {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	//@Disabled
	public void createTest() {
		OrderGr order = OrderGr
				.builder()
				.memberId("cangry")
				.build();
		orderMapper.create(order);
		log.info("주문 완료 : {}", order);
	}
}



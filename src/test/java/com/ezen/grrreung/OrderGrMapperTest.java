package com.ezen.grrreung;


import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.order.mapper.OrderMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class OrderGrMapperTest {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	@Disabled
	public void createTest() {
		OrderGr order = OrderGr
				.builder()
				.memberId("cangry")
				.build();
		orderMapper.create(order);

		log.info("주문 완료 : {}", order);
	}

	@Test
	public void historyTest() {
		List<Map<String,Object>> list =  orderMapper.orderHistoryByMember("customer1");
		for (Map<String, Object> order : list) {
			assertNotNull(order.get("ORDER_ID")); // ORDER_ID가 null이 아닌지 검증
			log.info("오더아이디 : {}",order.get("ORDER_ID"));
		}

	}
	}

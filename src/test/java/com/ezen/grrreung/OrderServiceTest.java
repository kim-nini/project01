package com.ezen.grrreung;

import com.ezen.grrreung.domain.transaction.NotEnoughMoneyException;
//import com.ezen.grrreung.domain.transaction.OrderGr;
import com.ezen.grrreung.domain.order.service.OrderService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

//@SpringBootTest
//@Slf4j
//public class OrderServiceTest {
//	@Autowired
//	private OrderService orderService;
//
//	@Test
//	@DisplayName("주문 정상 처리")
//	@Disabled
//	public void orderTest() throws NotEnoughMoneyException {
//		OrderGr order = new OrderGr();
//		order.setMemberId("heeyoung");
//		orderService.order(order);
//		log.info("주문 정상 처리 완료!");
//	}
//
//	@Test
//	@DisplayName("주문 런타임(시스템) 예외 발생 처리")
//	@Disabled
//	public void orderTest2() throws NotEnoughMoneyException {
//		OrderGr order = new OrderGr();
//		order.setMemberId("poor");
//		orderService.order(order);
//		log.info("시스템 예외로 주문 롤백 처리!");
//	}
//
//	@Test
//	@DisplayName("주문 비즈니스 예외 발생 처리")
//	//@Disabled
//	public void orderTest3() {
//		OrderGr order = new OrderGr();
//		order.setMemberId("not-sufficient");
//		try {
//		    orderService.order(order);
//		} catch (NotEnoughMoneyException e) {
//		    log.info("별도의 계좌로 입금 안내합니다.");
//		}
//	}
//}



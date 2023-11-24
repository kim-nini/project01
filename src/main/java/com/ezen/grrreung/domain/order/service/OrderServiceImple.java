package com.ezen.grrreung.domain.order.service;

import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.order.mapper.OrderMapper;
import com.ezen.grrreung.domain.transaction.NotEnoughMoneyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImple implements OrderService{
	
	private final OrderMapper orderMapper;

	@Override
	public List<Map<String, Object>> orderHistory(String memberId) {
		return orderMapper.orderHistoryByMember(memberId);
	}

//	//@Transactional
//	@Transactional(noRollbackFor = NotEnoughMoneyException.class)
//	public void order(OrderGr order) throws NotEnoughMoneyException {
//		log.info("========= OrderServiceImple.order() 메소드 호출됨 =========");
//		// #1. 주문테이블에 주문 관련 기본 정보 저장
//		orderMapper.create(order);
//		// #2. 결재 처리
//		log.info(">> 결제 진행.....");
//		// 시나리오1 : 회원 아이디가 poor인 경우 테스트를 위해 RuntimeException 발생 (롤백)
//		if (order.getMemberId().equals("poor")) {
//			log.info("※ 결재 관련 시스템(런타임) 예외 발생 ※");
//			throw new RuntimeException("시스템(런타임) 예외발생하였습니다.");
//		} else if (order.getMemberId().equals("not-sufficient")) {
//			// 시나리오2 : 회원 아이디가 not-poor인 경우 테스트를 위해 Exception 발생
//			log.info("※ 잔고 부족하여 비즈니스 예외 발생 ※");
//			// 주문테이블의 정보를 롤백하지 않고, payStatus를 대기로 변경
//			order.setPayStatus("대기");
//			orderMapper.updatePayStatus(order);
//			throw new NotEnoughMoneyException("not-sufficient 고객님 잔고가 부족합니다");
//		} else {
//			// 시나리오3 :  정상 결재 처리
//			log.info(">>>>>> 주문 및 결재가 정상 처리 되었습니다...");
//			order.setPayStatus("완료");
//			orderMapper.updatePayStatus(order);
//		}
//		log.info(">> 결제 완료.....");
//		log.info("========= OrderServiceImple.order() 메소드 종료됨 =========");}

}





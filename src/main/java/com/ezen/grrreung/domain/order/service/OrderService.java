package com.ezen.grrreung.domain.order.service;

import com.ezen.grrreung.domain.order.dto.OrderGr;
import com.ezen.grrreung.domain.transaction.NotEnoughMoneyException;

import java.util.Map;


public interface OrderService {
//	public void order(OrderGr order) throws NotEnoughMoneyException;

	// 주문 내역 조회
	public Map<String,String> orderHistory(String memberId);
}





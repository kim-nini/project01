package com.ezen.grrreung.domain.order.service;

import com.ezen.grrreung.domain.order.dto.Order;
import com.ezen.grrreung.domain.transaction.NotEnoughMoneyException;


public interface OrderService {
	public void order(Order order) throws NotEnoughMoneyException;
}





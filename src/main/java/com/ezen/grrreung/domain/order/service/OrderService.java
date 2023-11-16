package com.ezen.grrreung.domain.order.service;

import com.ezen.grrreung.domain.transaction.NotEnoughMoneyException;
import com.ezen.grrreung.domain.transaction.Order;

public interface OrderService {
	public void order(Order order) throws NotEnoughMoneyException;
}





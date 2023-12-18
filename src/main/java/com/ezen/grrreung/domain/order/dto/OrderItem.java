package com.ezen.grrreung.domain.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderItem {
	private int orderId;
	private int orderItemId;
	private int itemId;

	// 주문수량x상품가격-할인가격?
	private int orderPrice;
	private int orderAmount;

}


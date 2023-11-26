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
	private int orderPrice;
	private int orderAmount;

}


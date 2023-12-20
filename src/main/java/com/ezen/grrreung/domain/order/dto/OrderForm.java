package com.ezen.grrreung.domain.order.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderForm {

	private List<OrderItem> orderItems;

}


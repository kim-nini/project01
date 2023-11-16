package com.ezen.grrreung.domain.order.mapper;


import com.ezen.grrreung.domain.order.dto.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public void create(Order order);
	public void updatePayStatus(Order order);
}


package com.ezen.grrreung.domain.order.mapper;


import com.ezen.grrreung.domain.order.dto.OrderGr;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderMapper {
	public void create(OrderGr order);
	public void updatePayStatus(OrderGr order);
	
	// 주문 내역 조회
	public Map<String, Object> orderHistoryByMember(String memberId);
}


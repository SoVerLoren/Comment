package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Orders;
import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.dao.OrdersMapper;
import com.dingli.comment.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersMapper orderMap;

	@Override
	public List<Orders> getOrder() {
		
		
		return orderMap.selectAllOrders();
	}

	@Override
	public int addOrder(OrdersDto oDto) {
		
		return 0;
	}

}

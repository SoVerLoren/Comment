package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Orders;
import com.dingli.comment.bean.OrdersDto;

public interface OrderService {
	
	public List<Orders> getOrder();

	public int addOrder(OrdersDto oDto);

}

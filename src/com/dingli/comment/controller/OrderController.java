package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Orders;
import com.dingli.comment.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/getOrders")
	public String getOrder(@RequestParam(value="pageIndex",defaultValue="1") Integer i, Model m){
		PageHelper.startPage(i, 3);
		List<Orders> order=orderService.getOrder();
		PageInfo pageInfo=new PageInfo(order);
		m.addAttribute("OrderPageList", pageInfo);
		return "content/orderList";
	}
}

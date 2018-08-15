package com.yulu.service.impl;

import org.springframework.stereotype.Service;

import com.yulu.service.OrderService;
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Override
	public void add() {
		System.out.println("添加订单");
	}

}

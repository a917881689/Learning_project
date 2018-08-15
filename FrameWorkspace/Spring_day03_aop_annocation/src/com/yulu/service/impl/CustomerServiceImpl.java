package com.yulu.service.impl;

import org.springframework.stereotype.Service;

import com.yulu.service.CustomerService;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Override
	public void add() {
		System.out.println("添加客户");
	}

}

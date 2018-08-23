package com.yulu.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yulu.ssm.dao.ItemsMapper;
import com.yulu.ssm.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public void test() {
		System.out.println("开始执行service的test方法");
	}
}

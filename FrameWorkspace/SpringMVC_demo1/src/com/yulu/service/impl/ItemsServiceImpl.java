package com.yulu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yulu.service.ItemsService;
import com.yulu.spring.pojo.Items;
@Service
public class ItemsServiceImpl implements ItemsService{

	@Override
	public List<Items> findAll() {
		System.out.println("业务逻辑层");
		return null;
	}
	
}

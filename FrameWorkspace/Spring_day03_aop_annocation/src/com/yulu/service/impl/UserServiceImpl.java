package com.yulu.service.impl;

import org.springframework.stereotype.Service;

import com.yulu.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Override
	public void add() {
		System.out.println("添加用户");
	}

}

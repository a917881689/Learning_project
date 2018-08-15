package com.yulu.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
import com.yulu.service.UserService;
/**
 * 
 */
@Transactional
public class UserServiceImpl implements UserService {
	// dao实现类对象注入
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public void register(User user) {
		userDao.add(user);
	}

	@Override
	public void login(User user) {
		System.out.println("注册业务");
	}

}

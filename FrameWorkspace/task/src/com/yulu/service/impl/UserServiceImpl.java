package com.yulu.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.entity.User;
import com.yulu.service.UserService;
/**
 * 
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
	/**
	 * dao实现类对象注入
	 */
	@Autowired
	private UserMapper userMapper;

	@Override
	public int add(User user) {
		return userMapper.add(user);
	}

	@Override
	public User queryById(int id) {
		return userMapper.queryById(id);
	}
	@Override
	public int update(User user) {
		return userMapper.update(user);
	}
	@Override
	public int delete(int id) {
		return userMapper.delete(id);
	}
}

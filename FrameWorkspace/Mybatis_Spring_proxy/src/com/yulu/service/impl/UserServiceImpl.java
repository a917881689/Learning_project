package com.yulu.service.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.service.UserService;

public class UserServiceImpl extends SqlSessionDaoSupport implements UserService{

	@Override
	public User findUserById(Integer id) {
		UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
		User user = new User();
		user.setId(id);
		List<User> list = mapper.findUser(user);
		return list != null && list.size() ==1?list.get(0):null;
	}

	@Override
	public List<User> findUserByName(String name) {
		return null;
	}

	@Override
	public List<User> findUserByNameAndSex(String name, String sex) {
		return null;
	}
	
}

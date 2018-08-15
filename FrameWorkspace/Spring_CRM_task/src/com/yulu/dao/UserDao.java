package com.yulu.dao;

import com.yulu.entity.User;

public interface UserDao {
	// 添加客户
	boolean add(User user);

	User login(User user);
}

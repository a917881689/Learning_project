package com.yosakura.service.impl;

import java.util.List;

import com.yosakura.dao.impl.UserDaoImpl;
import com.yosakura.entity.User;


public class UserServiceImpl {
	public User login(User user) {
		UserDaoImpl udi = new UserDaoImpl();
		User result = udi.login(user);
		return result;
	}
	public boolean regist (User user) {
		UserDaoImpl udi = new UserDaoImpl();
		if (udi.queryByName(user.getUname()) != null) {
			return false;
		}
		return udi.regist(user);
	}
	public User queryByName(String uname) {
		return new UserDaoImpl().queryByName(uname);
	}
	public List<User> queryUserInfo(String uname) {
		return new UserDaoImpl().queryUserInfo(uname);
	}
}

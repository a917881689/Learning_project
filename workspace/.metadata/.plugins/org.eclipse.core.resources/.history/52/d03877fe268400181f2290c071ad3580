package com.yosakura.service.impl;

import com.yosakura.dao.impl.LoginDaoImpl;
import com.yosakura.entity.User;
import com.yosakura.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Override
	public User login(User user){
		String sql = "SELECT * FROM t_user WHERE user_name=? AND pwd=? AND type=?";
		return new LoginDaoImpl().Query(sql, user);
	}
}

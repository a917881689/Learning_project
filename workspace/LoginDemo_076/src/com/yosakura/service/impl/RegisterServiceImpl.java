package com.yosakura.service.impl;

import java.sql.SQLException;

import com.yosakura.dao.impl.RegisterDaoImpl;
import com.yosakura.entity.User;
import com.yosakura.service.RegisterService;

public class RegisterServiceImpl implements  RegisterService{
	@Override
	public int register(User user) {
		String sql = "INSERT INTO t_user(user_id,user_name,pwd,id_card,mobile,email,type) VALUES(t_user_id_seq.nextval,?,?,?,?,?,?)";
		int result = 0;
		try {
			result = new RegisterDaoImpl().addUser(sql, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

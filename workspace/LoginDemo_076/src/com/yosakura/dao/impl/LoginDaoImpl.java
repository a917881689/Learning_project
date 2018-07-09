package com.yosakura.dao.impl;

import java.sql.SQLException;

import com.yosakura.Util.JDBCUtil;
import com.yosakura.Util.SqlUtil;
import com.yosakura.dao.LoginDao;
import com.yosakura.entity.User;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User Query(String sql, User user) {
		Object[] objArray = SqlUtil.getObjAttr(user);
		user = null;
		try {
			user = JDBCUtil.singQuery(sql, objArray, new User());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}

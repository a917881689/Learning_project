package com.yosakura.web.dao.impl;

import java.sql.SQLException;

import com.yosakura.web.Util.JDBCUtil;
import com.yosakura.web.Util.SqlUtil;
import com.yosakura.web.dao.LoginDao;
import com.yosakura.web.entity.User;

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

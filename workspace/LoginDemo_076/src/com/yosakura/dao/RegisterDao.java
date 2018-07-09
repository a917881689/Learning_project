package com.yosakura.dao;

import java.sql.SQLException;

import com.yosakura.entity.User;

public interface RegisterDao {
	int addUser (String sql,User user) throws SQLException;
}

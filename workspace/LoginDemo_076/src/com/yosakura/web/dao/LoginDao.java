package com.yosakura.web.dao;

import com.yosakura.web.entity.User;

public abstract interface LoginDao {
	User Query(String sql,User user);
}

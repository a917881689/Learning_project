package com.yosakura.dao;

import com.yosakura.entity.User;

public abstract interface LoginDao {
	User Query(String sql,User user);
}

package com.yosakura.service;

import com.yosakura.entity.User;

public interface UserService {
	/**
	 * 用户注册
	 * @param user 待注册用户
	 * @return true 注册成功
	 */
	boolean regist (User user);
	
	/**
	 * 用户登陆
	 * @param user
	 * @return !=null 登录成功 
	 */
	User login (User user);
}

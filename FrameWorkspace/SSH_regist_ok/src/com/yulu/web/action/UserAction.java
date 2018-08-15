package com.yulu.web.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.User;
import com.yulu.service.UserService;
import com.yulu.util.MD5Utils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	@Resource(name="userService")
	private UserService userService;
	
	@Override
	public User getModel() {
		return user;
	}
	// 保存客户
	public String regist() {
		System.out.println("执行regist()方法");
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userService.register(user);
		return LOGIN;
	}
}

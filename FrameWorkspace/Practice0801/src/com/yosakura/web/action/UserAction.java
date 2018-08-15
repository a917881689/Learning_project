package com.yosakura.web.action;

import java.util.Objects;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
	public String login () {
		if (Objects.equals(user.getUname(),"admin") && Objects.equals(user.getPwd(),"123")) {
			System.out.println(user);
			return SUCCESS;
		}
		return "fail";
	}
	public String showShopCart () {
		if (Objects.equals(user.getUname(),"admin") && Objects.equals(user.getPwd(),"123")) {
			System.out.println(user);
			return "fail";
		}
		return SUCCESS;
	}
	public String personalCenter () {
		if (Objects.equals(user.getUname(),"admin") && Objects.equals(user.getPwd(),"123")) {
			System.out.println(user);
			return "fail";
		}
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
}

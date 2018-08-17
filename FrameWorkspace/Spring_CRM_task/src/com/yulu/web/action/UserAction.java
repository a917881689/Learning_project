package com.yulu.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.User;
import com.yulu.service.UserService;
import com.yulu.util.MD5Utils;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String result;
	@Resource(name="userService")
	private UserService userService;
	
	@org.apache.struts2.json.annotations.JSON
	public String getResult() {
		return result;
	}
	@Override
	public User getModel() {
		return user;
	}
	// 保存客户
	@Action(value="user-login",results= {
			@Result(name ="success", type="json",params={"root","result"}),
			@Result(name="login",type="redirect",location="/login.jsp")})
	public String login() {
		System.out.println("执行regist()方法");
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		User loginUser = userService.login(user);
		result = loginUser==null?LOGIN:SUCCESS;
		return SUCCESS;
	}
	
	// 保存客户
	@Action(value="user_regist",results= {
			@Result(name="login",type="redirect",location="/login.jsp")})
	public String regist() {
		System.out.println("执行regist()方法");
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		userService.register(user);
		return LOGIN;
	}
}

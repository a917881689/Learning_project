package com.yosakura.web.action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	private User user = new User();
	private String result = null;
	
	@Override
	public User getModel() {
		return user;
	}
	public String queryUserInfo() {
		// 2.调用业务逻辑层的验证用户名的接口
		User user = (User) session.get("loginUser");
		UserServiceImpl usi = new UserServiceImpl();
		List<User> list = usi.queryUserInfo(user.getUname());
		// 3.根据查询的结果来返回响应
		result = list == null || list.size() <= 0 ? NONE:JSON.toJSONString(list);
		System.out.println(result);
		return SUCCESS;
	}
	// 登录检查
	public String loginCk () {
		if (session == null || session.get("loginUser") == null) {
			result = NONE;
			return SUCCESS;
		}
		result = SUCCESS;
		return SUCCESS;
	}
	// 登录
	public String login () {
		UserServiceImpl usi = new UserServiceImpl();
		if (user.getUname() == null || Objects.equals(user.getUname(),"") || user.getPwd() == null || Objects.equals(user.getUname(),"") ) {
			result = ERROR;
			System.out.println("登录失败");
			return SUCCESS;
		}
		User loginUser = usi.login(user);
		if (loginUser == null) {
			result = NONE;
			System.out.println("登录失败");
			return SUCCESS;
		}
		session.put("loginUser", loginUser);
		System.out.println("登录成功");
		result = SUCCESS;
		return SUCCESS;
	}
	// 注销
	public String cancel () {
		// 注销只需要将session域中的登录成功后的用户移除即可;
		if (session == null || session.get("loginUser") == null) {
			System.out.println("用户未登录注销");
			result = NONE;
			return SUCCESS;
		}
		// 从session中删除属性对
		session.remove("loginUser");
		System.out.println("用户注销登录");
		result = SUCCESS;
		return SUCCESS;
	}
	// 注册
	public String regist () {
		System.out.println("注册开始");
		// 没有通过检查参数
		if(!registerCk()) {
			result = ERROR;
			return SUCCESS;
		}
		boolean flag = new UserServiceImpl().regist(user);
		System.out.println(flag?"注册成功":"注册失败");
		if (flag) {
			this.login();
		}
		result = flag ? SUCCESS:ERROR;
		return SUCCESS;
	}
	// 注册检查
	private boolean registerCk() {
		String uname = user.getUname();
		String pwd = user.getPwd();
		String email = user.getEmail();
		// 2.非空验证
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) || email == null || "".equals(email) ) {
			return false;
		}
		return true;
	}
	// 查询名字是否重复
	public String queryByName () {
		System.out.println("进入用户名验证");
		// 1.获取ajax请求用户名
		String uname = user.getUname();
		if (uname == null || "".equals(user.getUname())) {
			result = ERROR;
			return SUCCESS;
		}
		// 2.调用业务逻辑层的验证用户名的接口
		UserServiceImpl usi = new UserServiceImpl();
		User queryUser = usi.queryByName(user.getUname());
		// 3.根据查询的结果来返回响应
		result = queryUser == null ? "unuse":"use";
		System.out.println(result);
		return SUCCESS;
	}
	public String getResult() {
		return result;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}

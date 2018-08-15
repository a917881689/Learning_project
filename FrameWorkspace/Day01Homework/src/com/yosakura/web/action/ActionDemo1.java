package com.yosakura.web.action;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo1 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public String login () {
		// 获取表单中的参数(通过Servlet API获取请求对象)
		HttpServletRequest request = ServletActionContext.getRequest();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		// 此处正常应该差数据库，此处省略。。。
		if (Objects.equals(uname,"admin") && Objects.equals(pwd,"123")) {
			request.getSession().setAttribute("pwd",pwd);
			System.out.println(uname+":"+pwd);
			return SUCCESS;
		}
		return ERROR;
	}
}

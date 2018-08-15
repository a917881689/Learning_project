package com.yosakura.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.yosakura.domian.User;

public class AjaxActionTest extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public String ajax () throws IOException {
		// 返回一个json格式字符串
		User user = new User("admin","123");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(JSON.toJSONString(user));
		return NONE;
	}
}

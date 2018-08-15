package com.yosakura.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginCK extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 登录验证判断
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		// HttpSession session = ServletActionContext.getRequest().getSession();
		if (session == null || session.get("loginUser") == null) {
			System.out.println("未登录，进行拦截");
			return "error";	
		}
		return invocation.invoke();
	}
	
}

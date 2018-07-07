package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 创建servlet的步骤 (不建议使用)
 * 1.类实现Servlet接口
 * 2.重写接口的抽象方法(重点重写service方法)
 * 3.在web.xml中配置Servlet
 * Servlet的生命周期
 * 1.创建：【默认】第一次访问时有tomCat容器创建
 * 2.每一次访问都会执行service(get/post)方法
 * 3.当服务器关闭时销毁
 */
public class ServletDemo1 implements Servlet {
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet初始化");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet销毁");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet的service方法");
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

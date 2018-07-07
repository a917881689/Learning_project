package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建Servlet的步骤
 * 1.让一个类继承 HttpServlet(抽象类: 没有抽象方法)
 * 2.重点重写doGet(),doPost()方法
 * 3.在web.xml中配置servlet
 *
 */
public class ServletModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 此方法只能捕获get请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我是servlet的doGet()方法");
	}
	// 此方法只能捕获post请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我是servlet的doPost()方法");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet初始化");
	}
}

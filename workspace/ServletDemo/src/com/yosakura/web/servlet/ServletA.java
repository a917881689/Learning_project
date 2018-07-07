package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// ALT+Shift+s 打开Soure目录（构造，get,set,toString,重写）
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req 是请求对象（请求行 请求头 请求体）
		// resp 是响应对象（响应行 响应头 响应体）
		System.out.println("我是servletA 的service方法");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("我是servletA 的初始化方法");
	}
}

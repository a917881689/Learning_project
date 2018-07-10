package com.yosakura.web.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  模拟观音菩萨的Servlet
 *  转发，向域中存放法宝：芭蕉扇
 * @author Administrator
 *
 */
public class GuanYinServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 在request域（域对象：存取删）中存放一个法宝
		// 域中可以放无数个键值对（一次请求中）
		req.setAttribute("法宝","芭蕉扇");
		// 怎么实现转发(请求转发)
		// 使用请求获取对象转发器
		// RequestDispatcher dispatcher = req.getRequestDispatcher("niuMo");
		// 使用转发器实现转发功能（继续传递请求和响应）
		// dispatcher.forward(req, resp);
		// req.getRequestDispatcher("niuMo").forward(req, resp);
		
		// 转发不能转发到外部地址
		// req.getRequestDispatcher("https://www.baidu.com").forward(req, resp);
		
		
	}
}

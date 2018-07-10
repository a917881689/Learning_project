package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试响应的Servlet
 * @author Administrator
 *
 */
public class TestResponse extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 服务器如何接受到发来的请求内容
		String msg = req.getParameter("msg");
		System.out.println("客户端："+msg);
		// resp.getWriter() 获取打印字符流
		
		// 处理响应乱码（get,post一样处理）
		// 只能设置服务器 Response缓冲区的编码
		resp.setContentType("text/html;charset=utf-8");
		
		// 设置客户端的 编码
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("服务端： I'm fine thank you, and you?");
	}
}

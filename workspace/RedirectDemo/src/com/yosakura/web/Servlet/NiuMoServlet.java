package com.yosakura.web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 模拟牛魔王(接收妖怪和法宝并收复妖怪)
 * @author Administrator
 *
 */
public class NiuMoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取妖怪参数（请求参数）(重定向之后的请求参数不会携带)
		String monster = new String(req.getParameter("monster").getBytes("ISO-8859-1"),"UTF-8");
		String fabao = new String(req.getParameter("fabao").getBytes("ISO-8859-1"),"UTF-8");
		// 收复妖怪（响应）
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("牛魔王手持"+fabao+",来收复"+monster);
		
	}
}

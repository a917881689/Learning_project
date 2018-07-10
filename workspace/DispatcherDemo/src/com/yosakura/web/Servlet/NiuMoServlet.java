package com.yosakura.web.Servlet;

import java.io.IOException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模拟牛魔王的servlet
 * 1.接收到妖怪和法宝（待定）
 * 2.还会响应八戒来收复妖怪
 * @author Administrator
 *
 */
public class NiuMoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.接收到妖怪参数
		String monster = req.getParameter("monster");
		// 2.接收到观音赠的法宝 它时request域中的键值对
		String fabao = (String) req.getAttribute("法宝");
		// 3.响应八戒来收复妖怪
		monster = new String(monster.getBytes("ISO-8859-1"),"UTF-8");
		// resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("牛魔王手持:"+fabao+"，特来收复:"+monster);
	}
}

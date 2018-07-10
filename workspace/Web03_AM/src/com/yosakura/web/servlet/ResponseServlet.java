package com.yosakura.web.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应输出的几种方式
 * servlet可以嵌入前端html javascript语句
 * @author Administrator
 *
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out的类型 ：打印字节流 控制台输出
		PrintStream out = System.out; // 系统标准的系统输出
		out.println(97); // 输出97 换行
		out.print(97); // 输出97 不换行
		out.write(97); // 输出a 不换行
		out.flush(); // 刷新out.write的缓冲区
		
		
		resp.setContentType("text/html;charset=utf-8");
		// 输出到http响应中  
		// 封装到响应正文中
		PrintWriter pw = resp.getWriter();
		// 97 换行
		pw.println(97);
		// 输出a 
		pw.write(97);
		// 97 不换行
		pw.print(97);
		// Servlet 可以嵌入html代码
		pw.write("<hr/>");
		pw.write("<h2>静夜思</h2>");
		resp.getWriter().write("<h2 style='color:red'>床前明月光</h2>");
		resp.getWriter().write("<script type='text/javascript'>alert('弹框测试');</script>");
	}
}

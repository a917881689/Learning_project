package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.beans.Emp;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// 在request域中存放三种类型的值
		Emp e1 = new Emp(1,"关羽",123);
		Emp e2 = new Emp(2,"张飞",124);
		ArrayList<Emp> list = new ArrayList<Emp>();
		list.add(e1);
		list.add(e2);
		req.setAttribute("name","admin");
		req.setAttribute("emp", e1);
		req.setAttribute("list",list);
		// 在request域中存放值必须使用转发,才可以传递域参数/请求参数
		req.getRequestDispatcher("el_dispatcher.jsp").forward(req, resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
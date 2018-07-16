package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.beans.Emp;

@WebServlet("/addEmp")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
//		创建5员工并输出到网页表格中
		ArrayList<Emp> list = new ArrayList<>();
		list.add(new Emp(1,"1号员工",300));
		list.add(new Emp(2,"2号员工",600));
		list.add(new Emp(3,"3号员工",900));
		list.add(new Emp(4,"4号员工",1100));
		list.add(new Emp(5,"5号员工",1300));
		req.setAttribute("list",list);
		req.getRequestDispatcher("showEmp.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
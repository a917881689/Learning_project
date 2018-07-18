package com.yosakura.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yosakura.entity.User;
import com.yosakura.util.C3P0Util;

@WebServlet("/queryUserByName")
public class QueryUserByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.接受到异步请求的用户名参数
		String uname = req.getParameter("uname");
		// 2.此处省略service、dao
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT * FROM t_user where uname=?";
		try {
			User user = qr.query(sql,new BeanHandler<User>(User.class),uname);
		// 3.返回响应
			resp.getWriter().write(user==null?"ok":"error");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
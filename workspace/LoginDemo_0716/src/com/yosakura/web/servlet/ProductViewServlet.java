package com.yosakura.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yosakura.entity.Product;
import com.yosakura.util.C3P0Util;

@WebServlet("/productView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//此处省略（业务及dao层）
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from product";
		try {
			List<Product> products = qr.query(sql,new BeanListHandler<Product>(Product.class));
			req.setAttribute("products",products);
			req.getRequestDispatcher("productView.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
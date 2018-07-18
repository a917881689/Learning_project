package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;

@WebServlet("/lasterHistory")
public class LasterHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		String record = null;
		String[] recordArray = null;
		List<Product> list = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("record".equals(cookie.getName())) {
					record = cookie.getValue();
					recordArray = record.split(",");
					break;
				}
			}
			list = new ProductServiceImpl().queryProductsByidArray(recordArray);
		}
		for (Product product : list) {
			System.out.println(product);
		}
		req.setAttribute("lasterHistory", list);
		req.getRequestDispatcher("lasterHistory.jsp").forward(req, resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
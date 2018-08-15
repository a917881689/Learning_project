package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;

/**
 * 获取最近浏览的商品数据
 * @author Administrator
 *
 */
@WebServlet("/queryRecentlyBrowse")
public class QueryRecentlyBrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		String record = null;
		String[] recordArray = null;
		List<Product> list = null;
		String proListJSON = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("record".equals(cookie.getName())) {
					record = cookie.getValue();
					recordArray = record.split(",");
					break;
				}
			}
			if (recordArray != null) {
				list = new ProductServiceImpl().queryProductsByidArray(recordArray,3);
				proListJSON = JSON.toJSONString(list);
			}
		}
		System.out.println("proListJSON:"+proListJSON);
		resp.getWriter().write(proListJSON);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
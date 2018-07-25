package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

@WebServlet("/getShopCart")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		ShopServiceImpl ssi = new ShopServiceImpl();
		List<ShopCartModel> list = null;
		if (user != null) {
			// 用户登录
			long uid = user.getId();	
			// 查询购物车模型
			ssi.
			
		}else {
			// 用户未登录
			// 查询购物车模型
			String cookieShopCartjson = CookieUtil.getCookieValue(req.getCookies(),"shopCart");
			if (cookieShopCartjson == null || "".equals(cookieShopCartjson)) {
				return;
			}else{
				ssi.queryShopCart(cookieShopCartjson);
			}
		}
		resp.getWriter().write("");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
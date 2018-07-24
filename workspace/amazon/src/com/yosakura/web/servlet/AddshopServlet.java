package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yosakura.entity.Shop;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

@WebServlet("/addShop")
public class AddshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long pid = Long.parseLong(req.getParameter("pid"));
		Integer pnum = Integer.parseInt(req.getParameter("pnum"));
		User user = (User)req.getSession().getAttribute("loginUser");
		if (pid == null || "".equals(pid) || pnum == null || "".equals(pnum)) {
			resp.getWriter().write("error");
		}
		if (user != null) {
			// 用户登录
			long uid = user.getId();	
			// 创建购物车记录
			int result = new ShopServiceImpl().addShopCart(new Shop(pid,pnum,uid));
			resp.getWriter().write(result>0?"suc":"fail");
		}else {
			// 用户未登录
			Shop shop = new Shop(pid,pnum);
			// 判断cookie中是否有数据
			String cookieShopCartjson = CookieUtil.getCookieValue(req.getCookies(),"shopCart");
			String shopCartjson = null;
			if (cookieShopCartjson == null || "".equals(cookieShopCartjson)) {
				shopCartjson = JSON.toJSONString(shop);
			}else{
				List<Shop> shopCartList = JSON.parseArray(cookieShopCartjson,Shop.class);
				shopCartList.add(new Shop(pid,pnum));
				shopCartjson = JSON.toJSONString(shopCartList);
			}
			System.out.println("cookie购物车"+shopCartjson);
			Cookie cookie = new Cookie("shopCart",shopCartjson);
			cookie.setMaxAge(60*60*24*30);//过期时间为30天
			resp.addCookie(cookie);
			resp.getWriter().write("suc");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
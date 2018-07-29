package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.Shop;
import com.yosakura.entity.User;
import com.yosakura.util.CookieUtil;

// 数量更新后数据的添加到cookie中的临时购物车
@WebServlet("/updateShopCart")
public class UpdateTempShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pidStr = req.getParameter("pid");
		String pnumStr = req.getParameter("pnum");
		// 非空验证
		if (pidStr == null || "".equals(pidStr) || pnumStr == null || "".equals(pnumStr)) {
			resp.getWriter().write("error");
			return;
		}
		User user = (User)req.getSession().getAttribute("loginUser");
		long pid = Long.parseLong(pidStr);
		int pnum = Integer.parseInt(pnumStr);
		// 判断有没有登录
		if (user == null) {
			// 获取cookie中的临时购物车数据
			String cookieShopCart = CookieUtil.getCookieValue(req.getCookies(),"shopCart");
			// 进行更新，接收更新后的数据
			Shop shop = new Shop(pid,pnum);
			String updateCookieShopCart = CookieUtil.updateCookieShopCart(shop,cookieShopCart);
			// 转成cookie
			System.out.println("修改后的cookie"+updateCookieShopCart);
			Cookie cookie = new Cookie("shopCart",updateCookieShopCart);
			cookie.setMaxAge(60*60*24*3650);//过期时间为3650天
			resp.addCookie(cookie); // 添加到cookie
			resp.getWriter().write("sue");
			return;
		}
		// 登录了，判断购物车id 是否为空
		String sidStr = req.getParameter("sid");
		if (sidStr == null || "".equals(sidStr)) {
			System.out.println("sid为空");
			resp.getWriter().write("error");
			return;
		}
		long sid = Long.parseLong(sidStr);
		// 获取cookie中的临时购物车数据
		String tempShopCart = CookieUtil.getCookieValue(req.getCookies(),"tempShopCart");
		// 进行更新，接收更新后的数据
		Shop shop = new Shop(sid,pid,pnum,user.getId());
		String updateTempShopCart = CookieUtil.updateCookieTempShopCart(shop,tempShopCart);
		// 转成cookie
		System.out.println("修改后的cookie"+updateTempShopCart);
		Cookie cookie = new Cookie("tempShopCart",updateTempShopCart);
		cookie.setMaxAge(60*60*24*3650);//过期时间为3650天
		// 进行存储
		resp.addCookie(cookie);
		resp.getWriter().write("sue");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
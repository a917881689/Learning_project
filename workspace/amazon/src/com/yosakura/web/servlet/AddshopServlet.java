package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.Shop;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

@WebServlet("/addShop")
public class AddshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pidStr = req.getParameter("pid");
		String pnumStr = req.getParameter("pnum");
		
		User user = (User)req.getSession().getAttribute("loginUser");
		if (pidStr == null || "".equals(pidStr) || pnumStr == null || "".equals(pnumStr)) {
			resp.getWriter().write("error");
		}
		Long pid = Long.parseLong(pidStr);
		Integer pnum = Integer.parseInt(pnumStr);
		if (user != null) {
			// 用户登录
			long uid = user.getId();
			// 创建购物车记录
			ShopServiceImpl ssi = new ShopServiceImpl();
			// 截取临时购物车数据，进行更新
			List<Shop> tempShopCart = ssi.updateShopCart(uid,CookieUtil.getCookieValue(req.getCookies(),"tempShopCart"));
			resp.addCookie(CookieUtil.getTempCookie(tempShopCart));
			// 增加到购物车
			int result = ssi.addShopCart(new Shop(pid,pnum,uid));
			resp.getWriter().write(result>0?"suc":"fail");
		}
		// 用户未登录
		// 获取cookie中的购物车数据,增加到cookie购物车
		String cookieShopCartjson = CookieUtil.getCookieValue(req.getCookies(),"shopCart");
		String shopCartjson = CookieUtil.addCookieShopCart(pid,pnum,cookieShopCartjson);
		System.out.println("cookie购物车"+shopCartjson);
		Cookie cookie = new Cookie("shopCart",shopCartjson);
		cookie.setMaxAge(60*60*24*3650);//过期时间为3650天
		// Cookie cookie = new Cookie("shopCart",null);
		// cookie.setMaxAge(0); // 销毁
		resp.addCookie(cookie);
		resp.getWriter().write("suc");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
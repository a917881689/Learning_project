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
import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

@WebServlet("/getShopCart")
public class QueryShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		ShopServiceImpl ssi = new ShopServiceImpl();
		List<ShopCartModel> list = null;
		if (user != null) {
			// 用户登录
			long uid = user.getId();	
			Cookie[] cookies = req.getCookies();
			// getCookieValue()获取cookie临时购物车数据，updateShopCart()更新临时购物车数据
			 List<Shop> tempShopCart = ssi.updateShopCart(uid,CookieUtil.getCookieValue(cookies,"tempShopCart"));
			 resp.addCookie(CookieUtil.getTempCookie(tempShopCart));
			// 获取cookie购物车数据,查看是否有数据
			String cookieShopCartjson = CookieUtil.getCookieValue(cookies,"shopCart");
			if (cookieShopCartjson != null && !"".equals(cookieShopCartjson)) {
				// 添加cookie购物车数据到购物车
				ssi.addShopCart(uid,cookieShopCartjson);
				Cookie cookie = new Cookie("shopCart",null);
				cookie.setMaxAge(0); //销毁
				// 处理剩下的cookie购物车数据
				resp.addCookie(cookie);
			}
			list = ssi.queryShopCart(uid);		
		}else {
			// 用户未登录
			// 查询购物车模型
			String cookieShopCartjson = CookieUtil.getCookieValue(req.getCookies(),"shopCart");
			System.out.println("cookie数据"+cookieShopCartjson);
			if (cookieShopCartjson != null && !"".equals(cookieShopCartjson)) {
				list = ssi.queryShopCart(cookieShopCartjson);
			}	
		}
		String shopCartJSON = JSON.toJSONString(list);
		System.out.println("购物车数据"+shopCartJSON);
		// 处理空的购物车
		resp.getWriter().write(shopCartJSON);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
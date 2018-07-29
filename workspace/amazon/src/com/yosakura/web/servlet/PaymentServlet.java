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
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] sidArr = req.getParameterValues("choose_shop");
		User user = (User)req.getSession().getAttribute("loginUser");
		if (sidArr == null || sidArr.length <=0 || user == null) {
			resp.getWriter().write("error");
			return;
		}
		ShopServiceImpl ssi = new ShopServiceImpl();
		long uid = user.getId();
		// 更新cookie中的临时数据库
		List<Shop> tempShopCart = ssi.updateShopCart(uid,CookieUtil.getCookieValue(req.getCookies(),"tempShopCart"));
		resp.addCookie(CookieUtil.getTempCookie(tempShopCart));
		// 进行结算操作
		List<String> list = ssi.shopPayment(user,sidArr);
		System.out.println("结算剩余数据"+list);
		resp.getWriter().write(JSON.toJSONString(list));
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.Shop;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;

@WebServlet("/addshop")
public class AddshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long pid = Long.parseLong(req.getParameter("pid"));
		int pnum = Integer.parseInt(req.getParameter("pnum"));
		User user = (User)req.getSession().getAttribute("loginUser");
		long uid = user.getId();
		// 创建购物车记录
		int result = new ShopServiceImpl().addShopCart(new Shop(pid,pnum,uid));
		resp.getWriter().write(result>0?"suc":"fail");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
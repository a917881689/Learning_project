package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;

@WebServlet("/buyPro")
public class BuyProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pidStr = req.getParameter("pid");
		String pnumStr = req.getParameter("pnum");
		User user = (User)req.getSession().getAttribute("loginUser");
		if (pidStr == null || "".equals(pidStr) || pnumStr == null || "".equals(pnumStr) || user == null) {
			resp.getWriter().write("error");
		}
		long pid = Long.parseLong(pidStr);
		int pnum = Integer.parseInt(pnumStr);
		ShopServiceImpl ssi = new ShopServiceImpl();
		ssi.buyPro(user,pid,pnum);
		resp.getWriter().write("");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

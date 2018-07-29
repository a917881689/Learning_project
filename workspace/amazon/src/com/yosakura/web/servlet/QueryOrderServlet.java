package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.OrderModel;
import com.yosakura.entity.User;
import com.yosakura.service.impl.OrderServiceImpl;

@WebServlet("/getOrder")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("loginUser");
		// 非空验证
		if (user == null) {
			resp.getWriter().write("error");
			return;
		}
		// 获取订单数据
		OrderServiceImpl osi = new OrderServiceImpl();
		List<OrderModel> list = osi.queryOrder(user.getId());
		String jsonString = JSON.toJSONString(list);
		System.out.println("用户订单数据"+jsonString);
		resp.getWriter().write(jsonString);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
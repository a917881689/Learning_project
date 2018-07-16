package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yosakura.entity.Goods;
import com.yosakura.service.impl.GoodsServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int page = Integer.parseInt(req.getParameter("page"));
		List<Goods> goods = new GoodsServiceImpl().getGoods(page);
		JSONArray jsonData= JSONArray.parseArray(JSON.toJSONString(goods));
		System.out.println("value"+jsonData);
		//将数据发到JSP  
		RequestDispatcher rd = req.getRequestDispatcher("user.jsp");  
		req.setAttribute("goods",goods);//存值  
		rd.forward(req,resp);//开始跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

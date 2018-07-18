package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.Hero;

@WebServlet("/receiveArray")
public class ReceiveArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.创建英雄对象的集合
		ArrayList<Object> list = new ArrayList<>();
		list.add(new Hero(1L,"貂蝉",450,120));
		list.add(new Hero(2L,"阿狸",350,130));
		list.add(new Hero(3L,"琴妈",250,140));
		list.add(new Hero(4L,"大乔",150,150));
		list.add(new Hero(5L,"王元姬",050,160));
		String json = JSON.toJSONString(list);
		resp.getWriter().write(json);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
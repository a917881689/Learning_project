package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.News;
import com.yosakura.service.impl.NewsServiceImpl;
/**
 * 获取新闻信息
 *
 */
@WebServlet("/getNews")
public class QueryNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsServiceImpl psi = new NewsServiceImpl();
		List<News> list = psi.queryNews();
		String jsonString = JSON.toJSONString(list);
		System.out.println("加载新闻:"+jsonString);
		resp.getWriter().write(jsonString);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.PageListModel;
import com.yosakura.entity.ProductCategory;
import com.yosakura.service.impl.ProductServiceImpl;
/**
 *  查询商品分类信息
 *
 */
@WebServlet("/productClassify")
public class QueryProductClassifyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		ProductServiceImpl psi = new ProductServiceImpl();
		List<PageListModel<ProductCategory>> queryProductClassify = psi.queryProductClassify();
		String jsonString = JSON.toJSONString(queryProductClassify);
		System.out.println("获取商品分类信息："+jsonString);
		resp.getWriter().write(jsonString);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}

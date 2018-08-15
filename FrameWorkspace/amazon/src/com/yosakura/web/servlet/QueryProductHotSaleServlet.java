package com.yosakura.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;
/**
 *  热卖推荐商品信息
 * @author Administrator
 *
 */
@WebServlet("/popularProduct")
public class QueryProductHotSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductServiceImpl psi = new ProductServiceImpl();
		List<Product> list = psi.querypopularProduct();
		String jsonString = JSON.toJSONString(list);
		System.out.println("加载热卖商品信息:"+jsonString);
		resp.getWriter().write(jsonString);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
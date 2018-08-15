package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;

/**
 * 根据id查询商品信息返回商品对象
 * @author Administrator
 *
 */
@WebServlet("/queryProductByPId")
public class QueryProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		System.out.println("pid:"+pid);
		Product product = new ProductServiceImpl().queryProductById(pid);
		req.setAttribute("pro",product);
		String proJSON = JSON.toJSONString(product);
		resp.getWriter().write(proJSON);
		System.out.println("选择商品信息JSON:"+proJSON);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
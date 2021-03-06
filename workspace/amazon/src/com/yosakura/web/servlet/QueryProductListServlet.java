package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.PageModel;
import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;
/**
 * 分页展示商品
 * @author Administrator
 *
 */
@WebServlet("/query_pro_list")
public class QueryProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getParameter("info");
		String cid = req.getParameter("cid");
		System.out.println("条件:"+info);
		System.out.println("类别id:"+cid);
		// 1.获取当前页码
		String currentPage_s = req.getParameter("page");
		
		int currentPage = 1;
		if (currentPage_s != null) {
			System.out.println("页码:"+currentPage_s);
			currentPage = Integer.parseInt(currentPage_s);
		}
		// 2.服务器厂商定义一页显示多少个商品
		int pageSize = 12;
		// 3.调用service层的分页接口来获取PageModel
		ProductServiceImpl psi = new ProductServiceImpl();
		PageModel<Product> pageModel = psi.getProduct(cid,info,currentPage, pageSize);
		// 4.将分页模型转成json，输出给ajax
		String proPageJSON = JSON.toJSONString(pageModel);
		System.out.println("分页json数据："+proPageJSON);
		resp.getWriter().write(proPageJSON);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
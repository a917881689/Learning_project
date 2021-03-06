package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.PageModel;
import com.yosakura.entity.Product;
import com.yosakura.service.impl.ProductServiceImpl;
/**
 * 分页展示商品
 * @author Administrator
 *
 */
@WebServlet("/productView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getParameter("info");
		
		System.out.println("info:"+info);
		// 1.获取当前页码
		String currentPage_s = req.getParameter("currengPage");
		
		int currentPage = 1;
		if (currentPage_s != null) {
			System.out.println("currengPage:"+currentPage_s);
			currentPage = Integer.parseInt(currentPage_s);
		}
		// 2.服务器厂商定义一页显示多少个商品
		int pageSize = 12;
		// 3.调用service层的分页接口来获取PageModel
		ProductServiceImpl psi = new ProductServiceImpl();
		// 4.将分页模型存放到request中
		PageModel<Product> pageModel = null;
		if (info == null || "".equals(info)) {
			pageModel = psi.pageProduct(currentPage, pageSize);
			System.out.println(1);
		}else{
			pageModel = psi.queryProduct(info,currentPage, pageSize);
			System.out.println(2);
		}
		req.setAttribute("pageModel",pageModel);
		req.setAttribute("info",info);
		req.getRequestDispatcher("productView.jsp").forward(req, resp); 
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
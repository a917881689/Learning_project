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
		// 1.获取当前页码
		String currentPage_s = req.getParameter("currengPage");
		int currentPage = 1;
		if (currentPage_s != null) {
			currentPage = Integer.parseInt(currentPage_s);
		}
		// 2.服务器厂商定义一页显示多少个商品
		int pageSize = 12;
		// 3.调用service层的分页接口来获取PageModel
		ProductServiceImpl psi = new ProductServiceImpl();
		PageModel<Product> pageModel = psi.pageProduct(currentPage, pageSize);
		// 4.将分页模型存放到request中
		req.setAttribute("pageModel",pageModel);
		req.getRequestDispatcher("productView.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
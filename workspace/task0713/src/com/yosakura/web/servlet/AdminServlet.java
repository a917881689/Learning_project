package com.yosakura.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yosakura.entity.GType;
import com.yosakura.entity.Goods;
import com.yosakura.entity.User;
import com.yosakura.service.impl.GoodsServiceImpl;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String choose = req.getParameter("operation");
		if (choose != null) {
			switch (choose) {
			case "getGoodsType":
				List<GType> gtypes = new GoodsServiceImpl().getGoodsType();
				//将数据发到JSP  
//				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");  
//				req.setAttribute("goods",gtypes);//存值  
//				rd.forward(req,resp);//开始跳转
				JSONArray jsonData= JSONArray.parseArray(JSON.toJSONString(gtypes));
				System.out.println(jsonData);
				//把json数据传递到前端，前端用ajax接收
				resp.getWriter().print(jsonData);
				break;
			case "addGoods":
				Goods goods = new Goods(req.getParameter("gname"),Long.parseLong(req.getParameter("gtype")),Double.parseDouble(req.getParameter("price")));
				int result = new GoodsServiceImpl().addGoods(goods);
				System.out.println("result:"+result);
				resp.getWriter().print(result);
				break;
			case "getGoods":
				List<Goods> goodsList = new GoodsServiceImpl().getGoods();
				jsonData= JSONArray.parseArray(JSON.toJSONString(goodsList));
				System.out.println(jsonData);
				//把json数据传递到前端，前端用ajax接收
				resp.getWriter().print(jsonData);
				break;
			case "getGoods_where":
				System.out.println(req.getParameter("gtype"));
				System.out.println("name:"+req.getParameter("gname"));
				goods = new Goods(req.getParameter("gname"),Long.parseLong(req.getParameter("gtype")));
				goodsList = new GoodsServiceImpl().getGoods(goods);
				jsonData= JSONArray.parseArray(JSON.toJSONString(goodsList));
				System.out.println(jsonData);
				//把json数据传递到前端，前端用ajax接收
				resp.getWriter().print(jsonData);
				break;
			case "delGoods":
				long goodsId = Long.parseLong(req.getParameter("goods"));
				result = new GoodsServiceImpl().delGoods(goodsId);
				System.out.println("delResult:"+result);
				resp.getWriter().print(result);
				break;
			case "updateGoods":
				goods = new Goods(Long.parseLong(req.getParameter("goods")),req.getParameter("update_gname"),Long.parseLong(req.getParameter("update_gtype")),Double.parseDouble(req.getParameter("update_price")));
				result = new GoodsServiceImpl().updateGoods(goods);
				System.out.println("updateResult:"+result);
				resp.getWriter().print(result);
				break;
			default:
				break;
			}
		}else {
			// operation为空
		}
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
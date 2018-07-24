package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;

@WebServlet("/doRegist")
public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("注册开始");
		// 1.请求参数
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		String idCard = req.getParameter("idCard");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String utype = req.getParameter("utype");
		// 2.非空验证
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) || idCard == null || "".equals(idCard) || 
			mobile == null || "".equals(mobile) ||  email == null || "".equals(email) || utype == null || "".equals(utype) || 
			birthday == null || "".equals(birthday) || address == null || "".equals(address) || sex == null || "".equals(sex)) {
			resp.getWriter().write("<script type='text/javascript'>alert('信息不完整')</script");
			resp.setHeader("refresh", "1;url=register.jsp");
			return;
			// resp.sendRedirect("registUI.jsp");
		}
		User user = new User(uname, pwd,Integer.parseInt(sex),birthday,idCard, mobile, email,address, Integer.parseInt(utype));
		UserServiceImpl usi = new UserServiceImpl();
		boolean flag = usi.regist(user);
		if (flag) {
			resp.sendRedirect("reg-result.jsp");
			System.out.println("注册成功");
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('用户名已存在,注册失败')</script");
			System.out.println("注册失败");
			resp.setHeader("refresh", "1;url=register.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

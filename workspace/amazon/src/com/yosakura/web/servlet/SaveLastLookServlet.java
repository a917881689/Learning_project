package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.util.CookieUtil;

/**
 * 存储最近浏览
 * @author Administrator
 *
 */
@WebServlet("/saveLastLook")
public class SaveLastLookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		Cookie[] cookies = req.getCookies();
		String record = CookieUtil.getCookieValue(cookies,"record");
		String newRecord = null;
		if (record != null && record != "null") {
			// 获取历史记录字符串数组
			String[] records = record.split(",");
			// 获取一个去重之后并拼接,的字符串记录
			newRecord = CookieUtil.getString(CookieUtil.distict(records, pid));
		}else {
			// 直接获取id;
			newRecord = pid;
		}
		System.out.println("选择："+pid);
		System.out.println("旧记录："+record);
		System.out.println("新记录："+newRecord);
		Cookie cookie = new Cookie("record",newRecord);
		resp.addCookie(cookie);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
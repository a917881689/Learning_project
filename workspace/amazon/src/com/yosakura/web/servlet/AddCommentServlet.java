package com.yosakura.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.Comment;
import com.yosakura.service.impl.CommentServiceImpl;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String niName = req.getParameter("niName");
		String reply = req.getParameter("reply");
		String content = req.getParameter("content");
		System.out.printf("信息niName:%s  reply:%s  content:%s /n",niName,reply,content);
		if (niName == null || "".equals(niName) || reply == null || "".equals(reply) || content == null || "".equals(content)) {
			resp.getWriter().write("error");
			return;
		}
		Comment cm = new Comment(niName,reply,content);
		CommentServiceImpl csi = new CommentServiceImpl();
		int result = csi.addComment(cm);
		resp.getWriter().write(result==1?"suc":"error");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
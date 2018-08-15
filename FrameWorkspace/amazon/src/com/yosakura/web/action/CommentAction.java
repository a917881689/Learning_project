package com.yosakura.web.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.entity.Comment;
import com.yosakura.service.impl.CommentServiceImpl;

public class CommentAction extends ActionSupport implements ModelDriven<Comment> {
	private static final long serialVersionUID = 1L;
	private String result = null;
	private Comment comment = new Comment();
	@Override
	public Comment getModel() {
		return comment;
	}
	public String queryComment () {
		// 调用业务层查询接口获取数据
		List<Comment> list = new CommentServiceImpl().queryComment();
		String jsonString = JSON.toJSONString(list);
		// 转成json数据
		System.out.println("留言记录："+jsonString);
		result = jsonString;
		return SUCCESS;
	}
	public String addComment () {
		String niName = comment.getNickName();
		String reply = comment.getReply();
		String content = comment.getContent();
		System.out.printf("信息niName:%s  reply:%s  content:%s /n",niName,reply,content);
		if (niName == null || "".equals(niName) || reply == null || "".equals(reply) || content == null || "".equals(content)) {
			result = "error";
			return SUCCESS;
		}
		int resultnum = new CommentServiceImpl().addComment(comment);
		result = resultnum==1?"suc":"error";
		return SUCCESS;
	}
	public String getResult() {
		return result;
	}

}

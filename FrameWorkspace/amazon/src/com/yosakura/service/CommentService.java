package com.yosakura.service;

import java.util.List;

import com.yosakura.entity.Comment;

public interface CommentService {
	/**
	 * 查询留言记录
	 * @return 留言对象集合
	 */
	List<Comment> queryComment();

	/**
	 * 添加留言记录
	 * @param cm 留言对象
	 * @return 影响的行数
	 */
	int addComment(Comment cm);

}

package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.entity.Comment;

public interface CommentDao {

	/**
	 * 查询留言记录
	 * @return 留言对象集合
	 * @throws SQLException
	 */
	List<Comment> queryComment() throws SQLException;

	/**
	 * 添加留言记录
	 * @param cm
	 * @return
	 * @throws SQLException
	 */
	int addComment(Comment cm) throws SQLException;

}

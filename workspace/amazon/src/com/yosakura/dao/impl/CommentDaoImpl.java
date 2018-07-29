package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yosakura.dao.CommentDao;
import com.yosakura.entity.Comment;
import com.yosakura.util.C3P0Util;

public class CommentDaoImpl implements CommentDao{
	// 查询留言记录
	@Override
	public List<Comment> queryComment() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,reply,content,create_time,reply_time,nick_name,state FROM amz_comment ORDER BY create_time DESC";
		return qr.query(sql,new BeanListHandler<Comment>(Comment.class,new BasicRowProcessor(new GenerousBeanProcessor())));
	}
	// 添加留言记录
	@Override
	public int addComment(Comment cm) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "INSERT INTO amz_comment(reply,content,nick_name) VALUES(?,?,?)";
		return qr.update(sql,cm.getReply(),cm.getContent(),cm.getNickName());
	}

}

package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yosakura.dao.NewsDao;
import com.yosakura.entity.News;
import com.yosakura.util.C3P0Util;

public class NewsDaoImpl implements NewsDao {
	@Override
	public List<News> queryNews() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,title,content,create_time FROM amz_news ORDER BY create_time DESC limit 6";
		return qr.query(sql,new BeanListHandler<News>(News.class,new BasicRowProcessor(new GenerousBeanProcessor())));
	}
}

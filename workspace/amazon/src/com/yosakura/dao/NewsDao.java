package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.entity.News;

public interface NewsDao {

	/**
	 * 查询时间最近的六条新闻
	 * @return 时间最近的六条新闻的集合
	 * @throws SQLException 
	 */
	List<News> queryNews() throws SQLException;

}

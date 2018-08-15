package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.dao.impl.NewsDaoImpl;
import com.yosakura.entity.News;
import com.yosakura.service.NewsService;

public class NewsServiceImpl implements NewsService{
	// 查询时间最近的六条新闻
	@Override
	public List<News> queryNews() {
		List<News> list = null;
		try {
			list = new NewsDaoImpl().queryNews();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

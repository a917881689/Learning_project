package com.yosakura.service;

import java.util.List;

import com.yosakura.entity.News;

public interface NewsService {
	/**
	 * 查询时间最近的六条新闻
	 * @return 时间最近的六条新闻的集合
	 */
	List<News> queryNews();

}

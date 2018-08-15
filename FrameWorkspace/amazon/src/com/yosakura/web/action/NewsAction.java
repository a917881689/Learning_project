package com.yosakura.web.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.yosakura.entity.News;
import com.yosakura.service.impl.NewsServiceImpl;

public class NewsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String result = null;
	
	public String queryNews () {
		List<News> list = new NewsServiceImpl().queryNews();
		String jsonString = JSON.toJSONString(list);
		System.out.println("加载新闻:"+jsonString);
		result = jsonString;
		return SUCCESS;
	}
	
	public String getResult() {
		return result;
	}

}

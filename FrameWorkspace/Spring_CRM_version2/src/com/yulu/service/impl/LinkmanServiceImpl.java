package com.yulu.service.impl;

import javax.annotation.Resource;

import com.yulu.dao.LinkmanDao;
import com.yulu.entity.Linkman;
import com.yulu.service.LinkmanService;

public class LinkmanServiceImpl implements LinkmanService{
	@Resource(name="linkmanDao")
	private LinkmanDao linkmanDao;
	@Override
	public void add (Linkman linkman) {
		System.out.println("service获取:"+linkman);
		// linkmanDao.add(linkman);
		
		linkmanDao.add(linkman);

	}
}

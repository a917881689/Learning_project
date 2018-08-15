package com.yulu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.yulu.dao.LinkmanDao;
import com.yulu.entity.Linkman;
import com.yulu.service.LinkmanService;

public class LinkmanServiceImpl implements LinkmanService{
	@Resource
	private LinkmanDao linkmanDao;
	
	@Override
	public void add (Linkman linkman) {
		linkmanDao.add(linkman);
	}

	@Override
	public List<Linkman> find() {
		return linkmanDao.find();
	}
	@Override
	public Linkman queryById(long id) {
		return linkmanDao.queryById(id);
	}
	@Override
	public void update(Linkman linkman) {
		linkmanDao.update(linkman);
	}
}

package com.yulu.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.mybatis.mapper.LinkmanMapper;
import com.yulu.entity.Linkman;
import com.yulu.service.LinkmanService;
@Transactional
@Service
public class LinkmanServiceImpl implements LinkmanService{
	@Autowired
	private LinkmanMapper linkmanMapper;
	
	@Override
	public void add (Linkman linkman) {
		linkmanMapper.add(linkman);
	}

	@Override
	public List<Linkman> find() {
		return linkmanMapper.find();
	}
	@Override
	public Linkman queryById(long id) {
		return linkmanMapper.queryById(id);
	}
	@Override
	public void update(Linkman linkman) {
		linkmanMapper.update(linkman);
	}
}

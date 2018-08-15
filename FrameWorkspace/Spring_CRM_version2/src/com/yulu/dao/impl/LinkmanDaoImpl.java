package com.yulu.dao.impl;

import com.yulu.dao.LinkmanDao;
import com.yulu.entity.Linkman;

public class LinkmanDaoImpl implements LinkmanDao{
	@Override
	public void add (Linkman linkman) {
		System.out.println("dao获取:"+linkman);
	}
}

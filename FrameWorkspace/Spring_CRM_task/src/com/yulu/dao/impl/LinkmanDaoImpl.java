package com.yulu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.yulu.dao.LinkmanDao;
import com.yulu.entity.Linkman;

public class LinkmanDaoImpl implements LinkmanDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public long add (Linkman linkman) {
		System.out.println("linkmandao添加:"+linkman);
		long cid = (long) hibernateTemplate.save(linkman);
		return cid;
	}

	@Override
	public List<Linkman> find() {
		System.out.println("LinkmanDao执行了find方法");
		List<Linkman> list = (List<Linkman>) hibernateTemplate.find("from Customer");
		System.out.println("list="+list);
		return list;
	}
	@Override
	public Linkman queryById(long id) {
		System.out.println("LinkmanDaoImpl执行了queryById()");
		Linkman linkman = hibernateTemplate.get(Linkman.class, id);
		System.out.println("linkman:"+linkman);
		return linkman;
	}
	@Override
	public void update(Linkman linkman) {
		hibernateTemplate.update(linkman);
		System.out.println("更新成功");
	}
}

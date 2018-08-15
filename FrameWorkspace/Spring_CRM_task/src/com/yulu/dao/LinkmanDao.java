package com.yulu.dao;

import java.util.List;

import com.yulu.entity.Linkman;

public interface LinkmanDao {

	long add(Linkman linkman);

	List<Linkman> find();

	Linkman queryById(long id);

	void update(Linkman linkman);

}

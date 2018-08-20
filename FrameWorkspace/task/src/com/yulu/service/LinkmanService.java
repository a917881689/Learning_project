package com.yulu.service;

import java.util.List;

import com.yulu.entity.Linkman;

public interface LinkmanService {

	void add(Linkman linkman);

	List<Linkman> find();

	Linkman queryById(long id);

	void update(Linkman linkman);

}

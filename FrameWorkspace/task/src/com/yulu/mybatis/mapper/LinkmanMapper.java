package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.Linkman;

public interface LinkmanMapper {

	long add(Linkman linkman);

	List<Linkman> find();

	Linkman queryById(long id);

	void update(Linkman linkman);

}

package com.yulu.dao.impl;

import com.yulu.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void add() {
		System.out.println("增加客户");
	}

	@Override
	public String delete() {
		System.out.println("删除客户");
		return "后置通知返回值：删除成功";
	}

	@Override
	public void update() {
		System.out.println("修改客户");
	}

	@Override
	public void query() {
		System.out.println("查询客户");
		int a = 1/0;
	}
	
}

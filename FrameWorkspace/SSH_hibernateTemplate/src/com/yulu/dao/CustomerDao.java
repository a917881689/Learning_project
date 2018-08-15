package com.yulu.dao;

import java.util.List;

import com.yulu.entity.Customer;

public interface CustomerDao {
	// 添加客户
	void add(Customer customer);
	// 删除客户
	void delete(long id);
	// 更新客户
	void update(Customer customer);
	// 查询客户
	Customer queryById(long id);
	// 查询所有
	List<Customer> queryAll();
	// 模糊查询
	List<Customer> queryMoHu(String name);
}

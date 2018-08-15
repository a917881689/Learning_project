package com.yulu.service;

import java.util.List;

import com.yulu.entity.Customer;

public interface CustomerService {
	void addCustomer(Customer customer); 
	// 删除客户
	void delete(Long id);
	// 更新客户
	void update(Customer customer);
	// 查询所有
	List<Customer> queryAll();
	// 模糊查询
	List<Customer> queryMoHu(String name);
}

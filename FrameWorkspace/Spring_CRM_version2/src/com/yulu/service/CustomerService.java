package com.yulu.service;

import java.util.List;

import com.yulu.entity.Customer;

/**
 * 客户的业务类接口
 *
 */
public interface CustomerService {
	/**
	 * 添加客户的方法
	 * @param customer 客户
	 */
	void addCustomer(Customer customer);
	/**
	 * 查询客户列表
	 * @param customer
	 * @return
	 */
	List<Customer> findCustomer(); 
}

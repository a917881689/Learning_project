package com.yulu.dao;

import java.util.List;

import com.yulu.entity.Customer;

/**
 * 客户持久层数据接口（后面使用hibernate实现）
 *
 */
public interface CustomerDao {
	/**
	 * 客户添加方法
	 * @param customer 客户对象
	 */
	void add(Customer customer);
	/**
	 * 查询客户列表
	 * @return
	 */
	List<Customer> find();
}

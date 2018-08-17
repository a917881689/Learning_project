package com.yulu.service;

import org.hibernate.criterion.DetachedCriteria;

import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;

public interface CustomerService {
	/**
	 * 1.分页查询所有
	 * @param detachedCriteria 离线条件
	 * @param page 当前页
	 * @param rows 一页显示的记录数
	 * @return pageModel分页模型
	 */
	PageModel<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);
	/**
	 * 添加客户
	 * @param customer 客户
	 */
	void addCustomer(Customer customer);

}

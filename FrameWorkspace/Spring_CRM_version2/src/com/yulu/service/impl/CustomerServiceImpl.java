package com.yulu.service.impl;

import java.util.List;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;
/**
 * 客户业务逻辑层实现类
 * @author Administrator
 *
 */
public class CustomerServiceImpl implements CustomerService{
	// DI注入属性依赖
	private CustomerDao customerDao; 
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	// 添加客户
	@Override
	public void addCustomer(Customer customer) {
		// 调用DAO的添加方法
		System.out.println("service执行了addCustomer");
		customerDao.add(customer);
	}

	@Override
	public List<Customer> findCustomer() {
		System.out.println("findCustomer执行了");
		 List<Customer> list = customerDao.find();
		 return list;
	}

}

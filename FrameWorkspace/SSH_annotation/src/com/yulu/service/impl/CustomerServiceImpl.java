package com.yulu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;
/**
 * 
 */
@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	// dao实现类对象注入
	@Resource(name="customerDao")
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("service执行了addCustomer"+customer);
		customerDao.add(customer);
	}
}

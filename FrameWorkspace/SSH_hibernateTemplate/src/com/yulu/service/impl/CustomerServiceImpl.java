package com.yulu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;
/**
 * 
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	// dao实现类对象注入
	@Resource(name="customerDao")
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("service执行了addCustomer"+customer);
		customerDao.add(customer);
	}

	@Override
	public void delete(Long id) {
		customerDao.delete(id);		
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);		
	}

	@Override
	public List<Customer> queryAll() {
		return customerDao.queryAll();
	}

	@Override
	public List<Customer> queryMoHu(String name) {
		return customerDao.queryMoHu(name);
	}
}

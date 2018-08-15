package com.yulu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;
/**
 * 客户业务逻辑层实现类
 * @author Administrator
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService{
	// 注入属性
	@Resource(name="customerDao")
	private CustomerDao customerDao; 

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

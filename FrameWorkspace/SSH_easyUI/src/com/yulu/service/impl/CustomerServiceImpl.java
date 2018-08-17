package com.yulu.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;
import com.yulu.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService{
	// 注入customerDao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageModel<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		PageModel<Customer> pageModel = new PageModel<>();
		// 当前页
		pageModel.setCurrentPage(page);
		// 一页显示多少条
		pageModel.setPagesize(rows);
		Long total = customerDao.findCount(detachedCriteria);
		pageModel.setTotalCount(total);
		// 总页数
		Double num = Math.ceil(total*1.0/rows);
		pageModel.setTotalPage(num.intValue());
		// 当前页客户的集合
		Integer start = (page-1)*rows;
		List<Customer> list = customerDao.findByPage(detachedCriteria,start,rows);
		pageModel.setPageList(list);
		return pageModel;
	}
	// 添加客户
	@Override
	public void addCustomer(Customer customer) {
		customerDao.add(customer);
	}
	
}

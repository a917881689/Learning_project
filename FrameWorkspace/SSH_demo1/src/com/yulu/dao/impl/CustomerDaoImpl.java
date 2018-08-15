package com.yulu.dao.impl;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void add(Customer customer) {
		System.out.println("dao层执行了customer"+customer);
	}

}

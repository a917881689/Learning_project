package com.yulu.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(Customer customer) {
		System.out.println("dao层执行了customer"+customer);
		Serializable id = hibernateTemplate.save(customer);
		System.out.println("已经成功插入id为："+id);
	}

}

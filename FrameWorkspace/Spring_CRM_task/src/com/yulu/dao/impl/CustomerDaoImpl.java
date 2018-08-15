package com.yulu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
public class CustomerDaoImpl implements CustomerDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	@Override
	public void add(Customer customer) {
		System.out.println("DaoImpl执行了add"+customer);
		long cid = (Long)hibernateTemplate.save(customer);
		System.out.println(cid);
	}

	@Override
	public List<Customer> find() {
		System.out.println("CustomerDao执行了find方法");
		List<Customer> list = (List<Customer>) hibernateTemplate.find("FROM Customer");
		System.out.println("list="+list);
		return list;
	}

}

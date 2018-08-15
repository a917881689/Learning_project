package com.yulu.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
import com.yulu.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void add(Customer customer) {
		System.out.println("DaoImpl执行了add"+customer);
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Serializable id = session.save(customer);
		System.out.println("客户id："+id);
		tx.commit();
		session.close();
	}

	@Override
	public List<Customer> find() {
		System.out.println("执行了find方法");
		return null;
	}

}

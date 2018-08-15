package com.yulu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerDaoImpl implements CustomerDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void add(Customer customer) {
		System.out.println("DaoImpl执行了add"+customer);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		long cid = (Long)session.save(customer);
		tx.commit();
		System.out.println(cid);
		session.close();
	}
	@Test
	public void demoTest() {
		find();
	}
	@Override
	public List<Customer> find() {
		System.out.println("CustomerDao执行了find方法");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		tx.commit();
		System.out.println("list="+list);
		session.close();
		return list;
	}

}

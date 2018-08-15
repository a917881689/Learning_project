package com.yosakura.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yosakura.entity.User;

public class HibernateTest {
	@Test
	public void addUser () {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(new User(1L,"一号","一号pwd"));
		session.save(new User(2L,"二号","二号pwd"));
		session.save(new User(3L,"三号","三号pwd"));
		tx.commit();
		session.close();
	}
	@Test
	public void queryUser () {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
	@Test
	public void queryUserSingle () {
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "SELECT uname FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
}

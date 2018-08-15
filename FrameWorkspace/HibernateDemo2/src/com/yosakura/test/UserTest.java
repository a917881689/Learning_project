package com.yosakura.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yosakura.entity.User;
import com.yosakura.utils.HibernateUtil;

public class UserTest {
	@Test
	public void adduser () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUname("幻破");
		session.save(user);
		tx.commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}

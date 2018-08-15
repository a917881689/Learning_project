package com.yosakura.test;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yosakura.entity.User;
import com.yosakura.utils.HibernateUtil;

public class HibernateTest {
	// 5.保存或更新saveOrUpdate
	// saveorupdate,从字眼上看,就是保存或更新,
	// 那hibernate如何判断究竟是执行保存呢,还是执行更新呢.其实很简单,
	// 就是判断实体的主键是否为null,如果为null,那么保存,否则更新.
	@Test
	public void demo6 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(1L);
		user.setUname("幻破");
		System.out.println(user);
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}
	
	// 5.删除delete
	// @Test
	public void demo5 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		// 删除先查，若对象存在就删除
		// User user = session.get(User.class,3L);
		// session.delete(user);
		User user = new User();
		user.setId(1L);
		user.setUname("手段");
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	// 4.修改update
	// @Test
	public void demo4 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(2L);
		user.setUname("雨露2");
		user.setSex("女");
		// user.setBirthday(new Date());
		session.update(user);
		System.out.println(user);
		tx.commit();
		session.close();
	}
	
	
	// 3.查询load（面试：懒加载，延迟加载，优化手段）
	// @Test
	public void demo3 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		// 执行时不会发送sql语句
		User user = session.load(User.class,1L);
		// 使用对象时才会调用sql语句
		System.out.println(user);
		tx.commit();
		session.close();
	}
	
	// 2.查询get
	// @Test
	public void demo2 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,1L);
		System.out.println(user);
		tx.commit();
		session.close();
	}
	
	// save
	// @Test
	public void demo1 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUname("雨露");
		Serializable uid = session.save(user);
		System.out.println(uid);
		tx.commit();
		session.close();
	}
	
	
}

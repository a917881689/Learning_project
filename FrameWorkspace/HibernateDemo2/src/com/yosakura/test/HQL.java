package com.yosakura.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.yosakura.entity.User;
import com.yosakura.utils.HibernateUtil;
/**
 * HQL: 面向对象的查询语言
 * from 类名 Where 条件
 * query.list(); 获取集合数据
 * query.uniqueResult(); 获取单个对象
 */
public class HQL {
	// 4.分页查询
	@Test
	public void demo4 () {
		Session session = HibernateUtil.openSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(2);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		session.beginTransaction().commit();
		session.close();
	}
	
	// 3.查询指定记录
	@Test
	public void demo3 () {
		Session session = HibernateUtil.openSession();
		String hql = "FROM User WHERE uname=:uname";
		Query query = session.createQuery(hql);
		query.setString("uname","幻破");
		User user = (User)query.uniqueResult();
		System.out.println(user);
		session.beginTransaction().commit();
		session.close();
	}
	// 指定记录查询
	// @Test
	public void demo2 () {
		Session session = HibernateUtil.openSession();
		String hql = "FROM User WHERE uname=?";
		Query query = session.createQuery(hql);
		query.setString(0,"幻破");
		User user = (User)query.uniqueResult();
		System.out.println(user);
		session.beginTransaction().commit();
		session.close();
	}
	// 查询全部
	// @Test
	public void demo1 () {
		Session session = HibernateUtil.openSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.beginTransaction().commit();
		session.close();
		for (User user : list) {
			System.out.println(user);
		}
	}
}

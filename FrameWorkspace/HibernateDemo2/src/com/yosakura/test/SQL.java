package com.yosakura.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
public class SQL {
	// 查询全部
	@Test
	public void demo2 () {
		Session session = HibernateUtil.openSession();
		String sql = "select * from t_user";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		List<User> list = query.list(); 
		session.beginTransaction().commit();
		session.close();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	// 查询全部
	// @Test
	public void demo1 () {
		Session session = HibernateUtil.openSession();
		String sql = "select * from t_user";
		SQLQuery query = session.createSQLQuery(sql);
		List<Object> list = query.list(); 
		session.beginTransaction().commit();
		session.close();
		for (Object user : list) {
			System.out.println(user);
		}
	}
}

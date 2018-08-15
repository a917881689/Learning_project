package com.yulu.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateUtil {
	
	public static long add(Session session,Object obj) {
		System.out.println("HibernateUtil获取:"+obj);
		Transaction tx = session.beginTransaction();
		long id = (Long)session.save(obj);
		tx.commit();
		return id;
	}
	
	public static <T>List<T> findAll(Session session,Class<T> clazz) {
		System.out.println("HibernateUtil执行了find方法");
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(clazz);
		List<T> list = criteria.list();
		tx.commit();
		return list;
	}
}

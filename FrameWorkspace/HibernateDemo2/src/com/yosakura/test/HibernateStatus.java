package com.yosakura.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yosakura.entity.User;
import com.yosakura.utils.HibernateUtil;

/**
 * Hibernate的几种状态
 * 瞬时态（自由态）：新建之后没有OID ,没有和session关联
 *
 */
public class HibernateStatus {
	// 3.持久态对象可以实现自动更新(一级缓存)
	@Test
	public void demo3 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User u1 = session.get(User.class, 1L);
		u1.setPwd("236");
		tx.commit();
		session.close();
	}
	
	// 2.证明一级缓存的存在
	// @Test
	public void demo2 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User u1 = session.get(User.class, 1L);
		// 结束后将查询到的u1对象放入一级缓存中
		System.out.println("u1:"+u1);
		// 先从缓存中寻找OID=1的,若有则返回,没有则继续寻找数据库,查询后的结果又会放入一级缓存中
		User u2 = session.get(User.class, 1L);
		System.out.println("u2:"+u2);
		System.out.println(u1 == u2);
		tx.commit();
		session.close();
	}
	// 持久化对象的三种状态
	public void demo () {
		Session session = HibernateUtil.openSession();
		// 1.创建一个瞬时态对象 (没有OID,与session没有关联)
		User user = new User();
		user.setUname("雨露");
		// 2.持久态对象(拥有OID,且与session关联)
		session.save(user);
		User user2 = session.get(User.class,1L);
		session.beginTransaction().commit();
		session.close();
		
		// 托管状态（离线态,游离态）: 有OID,但与session失去了关联
		System.out.println(user2);
		
	}
}

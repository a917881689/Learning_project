package com.yosakura.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yosakura.entity.User;
import com.yosakura.util.HibernateUtil;

public class UserDaoImpl {
	
	public User login(User user) {
		Session session = HibernateUtil.openSession();
		String hql = "FROM User WHERE uname=:uname AND pwd=:pwd";
		Query query = session.createQuery(hql);
		query.setString("uname", user.getUname());
		query.setString("pwd", user.getPwd());
		User result = (User)query.uniqueResult();
		HibernateUtil.close(session);
		return result;
	}
	public User queryByName (String uname) {
		Session session = HibernateUtil.openSession();
		String hql = "FROM User WHERE uname=:uname";
		Query query = session.createQuery(hql);
		query.setString("uname",uname);
		User result = (User)query.uniqueResult();
		HibernateUtil.close(session);
		return result;
	}
	
	public User queryById (long uid) {
		Session session = HibernateUtil.openSession();
		User result = session.get(User.class,uid);
		HibernateUtil.close(session);
		return result;
	}
	public List<User> queryUserInfo (String uname) {
		Session session = HibernateUtil.openSession();
		String hql = "SELECT new User(id,uname) FROM User WHERE uname !=:uname";
		Query query = session.createQuery(hql);
		query.setString("uname",uname);
		List<User> list = query.list();
		HibernateUtil.close(session);
		return list;
	}
	public boolean regist(User user) {
		Session session = HibernateUtil.openSession();
		Long result = (Long)session.save(user);
		HibernateUtil.close(session);
		return result>0;
	}

}

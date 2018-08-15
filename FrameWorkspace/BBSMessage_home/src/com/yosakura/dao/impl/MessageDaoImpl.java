package com.yosakura.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.yosakura.entity.Message;
import com.yosakura.util.HibernateUtil;

public class MessageDaoImpl {
	
	public long queryInboxCount(long uid) {
		System.out.println("dao"+uid);
		Session session = HibernateUtil.openSession();
		Query query = session.createQuery("SELECT count(*) FROM Message WHERE recipient_uid=:uid");
		query.setLong("uid",uid);
		long count = (long) query.uniqueResult();
		HibernateUtil.close(session);
		return count;
	}
	
	public List<Message> queryInbox(long uid,int beginPage,int page) {
		System.out.println("dao"+uid);
		Session session = HibernateUtil.openSession();
		String hql = "FROM Message WHERE recipient_uid=:uid ORDER BY create_date DESC";
		Query query = session.createQuery(hql);
		query.setLong("uid",uid);
		int start = (beginPage-1)*page;
		query.setFirstResult(start);
		query.setMaxResults(page);
		List<Message> list = query.list();
		HibernateUtil.close(session);
		return list;
	}

	public Message querySingleMsg(Long id) {
		Session session = HibernateUtil.openSession();
		Message msg = session.get(Message.class,id);
		// 判断是否已读,不是已读,修改已读
		if(msg.getType() == 1) {
			msg.setType(2);
		}
		System.out.println("数据库信息："+msg);
		HibernateUtil.close(session);
		return msg;
	}

	public void updateMsgType(Message msg) {
		Session session = HibernateUtil.openSession();
		session.update(msg);
		HibernateUtil.close(session);
	}
	
	public long addMsg(Message msg) {
		Session session = HibernateUtil.openSession();
		long mid = (long)session.save(msg);
		HibernateUtil.close(session);
		return mid;
	}
}

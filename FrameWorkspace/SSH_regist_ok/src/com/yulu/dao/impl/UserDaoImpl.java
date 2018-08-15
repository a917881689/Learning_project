package com.yulu.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public boolean add(User user) {
		System.out.println("dao层执行了customer"+user);
		long id = (long) this.getHibernateTemplate().save(user);
		return id>0;
	}

}

package com.yulu.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.yulu.dao.CustomerDao;
import com.yulu.dao.UserDao;
import com.yulu.entity.Customer;
import com.yulu.entity.User;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("dao层执行了customer"+user);
		/*Serializable id = this.getHibernateTemplate().save(user);
		System.out.println("已经成功插入id为："+id);*/
	}

}

package com.yulu.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public void add(Customer customer) {
		System.out.println("dao层执行了customer"+customer);
		Serializable id = this.getHibernateTemplate().save(customer);
		System.out.println("已经成功插入id为："+id);
	}

}

package com.yulu.dao.impl;

import java.io.Serializable;
import java.util.List;

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

	// 删除客户
	@Override
	public void delete(long id) {
		Customer customer = queryById(id);
		getHibernateTemplate().delete(customer);
		System.out.println("删除成功！");
	}

	// 修改客户
	@Override
	public void update(Customer customer) {
		getHibernateTemplate().update(customer);
		System.out.println("修改成功");
	}

	@Override
	public Customer queryById(long id) {
		return getHibernateTemplate().get(Customer.class,id);
	}

	@Override
	public List<Customer> queryAll() {
		List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer");
		return list;
	}

	@Override
	public List<Customer> queryMoHu(String name) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer where cust_name like","%"+name+"%");
		return list;
	}

}

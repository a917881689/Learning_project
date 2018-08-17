package com.yulu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.yulu.dao.CustomerDao;
import com.yulu.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public Long findCount(DetachedCriteria detachedCriteria) {
		DetachedCriteria criteria = detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer start, Integer rows) {
		detachedCriteria.setProjection(null);
		return (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, start, rows);
	}

	@Override
	public void add(Customer customer) {
		getHibernateTemplate().save(customer);
	}

}

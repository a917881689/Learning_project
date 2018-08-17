package com.yulu.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.yulu.entity.Customer;

public interface CustomerDao {
	/**
	 * 查询总记录数
	 * @param detachedCriteria
	 * @return
	 */
	public Long findCount(DetachedCriteria detachedCriteria);
	/**
	 * 查询当前页的数据集合
	 * @param detachedCriteria 
	 * @param start 起始行
	 * @param rows 一页显示记录数
	 * @return
	 */
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer start, Integer rows);
	/**
	 * 添加客户
	 * @param customer 客户对象
	 */
	public void add(Customer customer);

}

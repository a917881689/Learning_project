package com.yulu.service;

import java.util.List;

import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;

/**
 * 客户的业务类接口
 *
 */
public interface CustomerService {
	/**
	 * 添加客户的方法
	 * @param customer 客户
	 */
	int addCustomer(Customer customer);
	/**
	 * 查询客户列表
	 * @param
	 * @return
	 */
	List<Customer> findCustomer();

    /**
     * 删除客户
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 修改客户
     * @param customer
     * @return
     */
    int update(Customer customer);

    /**
	 * 模糊分页查询
     * @param name 名字
	 * @param page 页数
	 * @param rows 条数
	 * @return
	 */
    PageModel<Customer> find(String name, Integer page, Integer rows);

}

package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * 客户持久层数据接口（后面使用hibernate实现）
 *
 */
public interface CustomerMapper {
	/**
	 * 客户添加方法
	 * @param customer 客户对象
	 * @return 影响行数
	 */
	int add(Customer customer);

	/**
	 * 删除客户
	 * @param id
	 * @return
	 */
	int delete(long id);

	/**
	 * 修改客户
	 * @param customer 客户对象
	 * @return
	 */
	int update(Customer customer);
	/**
	 * 查询客户列表
	 * @return
	 */
	List<Customer> find();

	/**
	 * 查询客户数量
	 * @return 客户总数量
	 */
    Long findCount();

	/**
	 * 分页查询
	 * @param start 开始
	 * @param rows 条数
	 * @return 客户集合
	 */
	List<Customer> findPage(Integer start, Integer rows);

	/**
	 * 模糊查询
	 * @param name 名字
	 * @return 数量
	 */
	Long findCountByName(String name);
	/**
	 * 分页查询
	 * @param name 姓名
	 * @param start 开始
	 * @param rows 条数
	 * @return 客户集合
	 */
	List<Customer> findPageByName(String name, Integer start, Integer rows);
}

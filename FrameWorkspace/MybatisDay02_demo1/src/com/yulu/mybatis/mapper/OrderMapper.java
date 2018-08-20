package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.Order;

/**
 * 订单的映射接口
 *
 */
public interface OrderMapper {
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	List<Order> findAllOrder();
	/**
	 * 查询所有的订单信息 resultMap
	 * @return
	 */
	List<Order> findAllOrderByResultMap();
	/**
	 * 两表查询（显示订单的用户名和地址和用户id）
	 * @return
	 */
	List<Order> findAllOrder2();
	/**
	 * resultMap查询
	 * @return
	 */
	List<Order> findAllOrder3();
}

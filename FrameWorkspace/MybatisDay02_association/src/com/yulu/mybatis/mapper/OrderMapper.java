package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.Order;

/**
 * 订单的映射接口
 *
 */
public interface OrderMapper {
	/**
	 * 通过订单管理查询用户信息（一对一）
	 * @return
	 */
	List<Order> findAllOrderUser();
}

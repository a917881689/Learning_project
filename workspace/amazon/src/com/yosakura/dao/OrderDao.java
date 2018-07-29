package com.yosakura.dao;

import java.sql.SQLException;

import com.yosakura.entity.Order;
import com.yosakura.entity.OrderDetail;

public interface OrderDao {

	/**
	 * 增加订单数据
	 * @param order 订单数据
	 * @return 订单id
	 * @throws SQLException
	 */
	long addOrderAffair(Order order) throws SQLException;
	/**
	 * 增加订单详情数据
	 * @param orderDetail 订单详情数据
	 * @return 影响的行数
	 * @throws SQLException
	 */
	int addOrderDeteilAffair(OrderDetail orderDetail) throws SQLException;

}

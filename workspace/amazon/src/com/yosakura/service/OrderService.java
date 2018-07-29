package com.yosakura.service;

import java.util.List;

import com.yosakura.entity.OrderModel;

public interface OrderService {

	/**
	 * 获取用户订单数据业务接口
	 * @param uid 用户
	 * @return 订单数据模型对象集合
	 */
	List<OrderModel> queryOrder(long uid);

}

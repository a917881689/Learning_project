package com.yulu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.Order;
import com.yulu.entity.User;
import com.yulu.mybatis.mapper.OrderMapper;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

public class MyTest {
	//一对多查询所有订单信息及用户信息
	@Test
	public void demo2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findAllUserOrder();
		for (User user : list) {
			System.out.println(user+"/n");
			System.out.println(user.getOrders());
		}
	}
	//一对一 关联查询所有订单信息及用户信息
	//@Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = mapper.findAllOrderUser();
		for (Order order : list) {
			System.out.println(order+"/n");
		}
	}
	
}

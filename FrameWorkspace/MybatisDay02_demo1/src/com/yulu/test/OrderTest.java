package com.yulu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.Order;
import com.yulu.mybatis.mapper.OrderMapper;
import com.yulu.util.MybatisUtil;

public class OrderTest {
	
	//查询所有订单信息及用户信息
	@Test
	public void demo3() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = mapper.findAllOrderByResultMap();
		System.out.println(list);
	}
	//查询所有订单信息及用户信息
	//@Test
	public void demo2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = mapper.findAllOrder2();
		System.out.println(list);
	}
	// 查询所有订单信息
	//@Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = mapper.findAllOrder();
		System.out.println(list);
	}
	
}

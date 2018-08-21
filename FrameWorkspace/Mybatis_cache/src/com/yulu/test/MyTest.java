package com.yulu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

public class MyTest {
	@Test
	public void demo2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(36);
		// Mybatis存在一级缓存区，结构式Map(sql语句，结果)
		// 一级缓存结构,map（SELECT * FROM `user` WHERE id=36，user）
		// 手动清除缓存验证结果 ,每次提交都会清空缓存区
		// sqlSession.clearCache();
		// sqlSession.commit();
		User user2 = mapper.findUserById(36);
		System.out.println(user==user2);
	}
	// @Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findAll();
		System.out.println(list);
	}
}

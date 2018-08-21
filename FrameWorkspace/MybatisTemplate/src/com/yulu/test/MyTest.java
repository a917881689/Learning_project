package com.yulu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

public class MyTest {
	
	@Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findAll();
		System.out.println(list);
		
	}
}

package com.yulu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

public class UserMapperTest {

	@Test
	public void demotest() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> queryAll = userMapper.queryAll();
		System.out.println(queryAll);
		System.out.println("26号："+userMapper.queryUserById(26));
	}
}

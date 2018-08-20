package com.yulu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;
/**
 * Mybatis中的动态sql专门用于
 * @author Administrator
 *
 */
public class MyTest {
	// 迭代标签
	@Test
	public void demo2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String,ArrayList<Integer>> hashMap = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(24);
		list.add(26);
		list.add(27);
		hashMap.put("userIds",list);
		List<User> list2 = mapper.findUserById(hashMap);
		System.out.println(list2);
	}
	// 动态的迭代标签
	// @Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(26);
		List<User> list = mapper.findUser(user);
		System.out.println(list);
	}
	
}

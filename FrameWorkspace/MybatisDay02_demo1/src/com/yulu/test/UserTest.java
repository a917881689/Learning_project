package com.yulu.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yulu.entity.Order;
import com.yulu.entity.User;
import com.yulu.entity.UserPro;
import com.yulu.mybatis.mapper.OrderMapper;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

public class UserTest {
	// 查询所有用户记录数
	// @Test
	public void demo6() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(27);
		System.out.println(user);
	}
	// 查询所有用户记录数
	// @Test
	public void demo5() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Long userCount = mapper.findUserCount();
		System.out.println(userCount);
	}
	// 根据性别和名字模糊查询
	// @Test
	public void demo4() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String,String> map = new HashMap<>();
		map.put("name","房");
		map.put("sex","女");
		List<User> list = mapper.findUserBySexAndName(map);
		System.out.println(list);
	}
	// 根据名字模糊查询
	// @Test
	public void demo3() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		UserPro userPro = new UserPro();
		userPro.setUser(user);
		List<User> list = mapper.findByUserPro(userPro);
		System.out.println(list);
	}
	// 根据名字模糊查询
	// @Test
	public void demo2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findUserByName("陈");
		System.out.println(list);
	}
	
	// @Test
	public void demo1() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findAll();
		System.out.println(list);
	}
}

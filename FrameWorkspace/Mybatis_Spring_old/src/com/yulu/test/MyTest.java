package com.yulu.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;

public class MyTest {
	private ApplicationContext applicationContext;
	// 单元测试的注解,当执行单元测试之前，每次都会执行此方法
	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void demo1() {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		List<User> list = userDao.findUserByName("房");
		System.out.println(list);
		
	}
}

package com.yulu.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.entity.User;
import com.yulu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="userService2")
	private UserService userService2;
	
	@Test
	public void demo2() {
		User user = userService.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void demo1() {
		User user = userService.findUserById(26);
		System.out.println(user);
	}
}

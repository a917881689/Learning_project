package com.yulu.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest2 {
	@Resource(name="userDao")
	private UserDao userDao;
	// 添加
	@Test
	public void demo2() {
		User user = new User("李海清",new Date(),"男","娜娜奇");
		Integer id = userDao.insertUser(user);
		// mybatis默认是自动提交的，hibernate默认事务是手动提交的（必须配置TX）
		System.out.println(id);
	} 
	// 查询
	//@Test
	public void demo1() {
		List<User> list = userDao.findUserByName("房");
		System.out.println(list);
	}
}

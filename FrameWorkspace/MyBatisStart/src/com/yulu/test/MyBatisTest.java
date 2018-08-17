package com.yulu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yulu.dao.impl.UserDaoImpl;
import com.yulu.entity.User;
import com.yulu.util.MybatisUtil;

public class MyBatisTest {
	@Test
	public void demoTest() {
		UserDaoImpl udi = new UserDaoImpl();
		/*List<User> findAll =udi.findAll();
		System.out.println(findAll);*/
		// System.out.println(udi.findUserById(26));
	}
	// 4.更新用户
	//@Test
	public void demo5 () throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		int row = sqlSession.delete("user.deleteUserById",33);
		System.out.println(row==1?"删除成功":"删除失败");
	}
	// 4.更新用户
	//@Test
	public void demo4 () throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		User user = new User();
		user.setId(26);
		user.setSex("男");
		user.setAddress("温比亚");
		int update = sqlSession.update("user.updateUserById",user);
	}
	// 3.根据用户名模糊查询用户信息
	// @Test
	public void demo3 () throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		User user = new User("圣诞老人",new Date(),"男","圣诞树");
		int insert = sqlSession.insert("user.insertUser", user);
		System.out.println(insert);
		sqlSession.close();
	}
	// 2.根据用户名模糊查询用户信息
	// @Test
	public void demo2 () throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		List<User> list = sqlSession.selectList("user.queryUserByName","%张%");
		System.out.println(list);
		sqlSession.close();
	}
	// 1.根据用户ID查询用户信息
	// @Test
	public void demo1 () throws IOException {
		// 获取SqlSessionFactory的建造者
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 将src文件以流的形式加载
		InputStream inputStream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
		// 通过建造者来构造工厂SqlSessionFactory
		SqlSessionFactory sessionFactory = ssfb.build(inputStream);
		// 通过工厂创建Session会话对象 (相当于JDBC的连接对象)
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("user.queryUserById",10);
		System.out.println(user);
		// 释放资源(归还SessionFactory)
		sqlSession.close();
	}
}

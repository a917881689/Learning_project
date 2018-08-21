package com.yulu.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Mybatis工具
 *  1.提供获取SqlSessionFactory方法（工厂唯一） 
 *  2.提供获取SqlSession方法
 */
public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	// 1.类加载的时候首先加载静态代码块，并且只会加载一次，一般用于加载驱动或创建工厂
	static {
            ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			//3.通过建造者来构造SqlSessionFactory
			sqlSessionFactory = (SqlSessionFactory)ac.getBean("sqlSessionFactory");
	}
	/**
	 * 1.提供获取SqlSessionFactory方法（工厂唯一） 
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	/**
	 * 2.提供获取SqlSession方法
	 * @param flag  true:自动提交session ,false默认手动提交
	 */
	public static SqlSession getSqlSession(boolean flag) {
		return sqlSessionFactory.openSession(flag);
	}
	
}















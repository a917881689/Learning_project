package com.yulu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis工具
 * 1.提供获取SqlSessionFactory （工厂唯一）
 * 2.提供获取SqlSession方法
 *
 */
public class MybatisUtil {
	private static SqlSessionFactory sessionFactory;
	// 1.类加载的时候首先加载静态代码块，并且只会加载一次，一般用于加载驱动或加载工厂
	static {
		SqlSessionFactoryBuilder sfbu = new SqlSessionFactoryBuilder();
		InputStream is;
		try {
			is = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			sessionFactory = sfbu.build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * 2.提供获取sqlSession的方法
	 * @param flag true:自动关闭session false：手动关闭session
	 * @return
	 */
	public static SqlSession getSqlSession(boolean flag) {
		return sessionFactory.openSession(flag);
	}
}

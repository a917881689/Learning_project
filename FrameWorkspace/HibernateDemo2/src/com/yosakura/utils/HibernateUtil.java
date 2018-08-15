package com.yosakura.utils;
/**
 * Hibernate工具类
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static{
		// 1.读取核心配置文件
		Configuration configure = new Configuration().configure();
		// configure.addInputStream(映射文件流);
		// 2.通过核心配置文件获取session工厂
		sessionFactory = configure.buildSessionFactory();
	}
	// 获取session工厂
	public static SessionFactory getSessionFactory () {
		return sessionFactory;
	}
	// 获取普通的session对象，但使用完成后需要关闭
	public static Session openSession () {
		// 3.通过session工厂获取session对象（类似于数据库连接对象）
		return sessionFactory.openSession();
	}
	// 获取与线程绑定的session(用于事务处理) (线程死亡则session自动销毁),因此不能手动关闭（关了会报异常）
	public static Session getCurrentSession () {
		// 3.通过session工厂获取session对象（类似于数据库连接对象）
		return sessionFactory.getCurrentSession();
	}
}

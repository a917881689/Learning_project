package com.yosakura.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * C3P0工具：获取数据源和数据库连接对象
 * @author Administrator
 *
 */

import oracle.jdbc.proxy.annotation.GetCreator;
public class C3P0Util {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//对外提供获取数据源的方法
	public static ComboPooledDataSource getDataSoure () {
		return dataSource;
	}
	// 对外提供获取数据库连接对象的方法
	public static Connection getConnection () {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// 通过数据源获取连接对象
			System.out.println("获取连接对象失败");
		}
		return conn;
	}
	// 3.获取dbutils的查询对象
	public static QueryRunner getQueryRunner () {
		return new QueryRunner(dataSource);
	}
}

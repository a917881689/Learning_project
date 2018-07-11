package com.yosakura.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yosakura.util.C3P0Util;

/**
 * C3P0 使用步骤
 * 1.将C3P0-config.xml放到src下
 * 2.加载配置文件
 *
 */
public class C3P0Test {
	public static void main(String[] args) throws SQLException {
		// 1.加载src下的C3P0-config.xml的默认配置
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection mysqlConn = dataSource.getConnection();
		// 2.如歌获取Oracle 数据库的连接对象？
		ComboPooledDataSource dataSource2 = new ComboPooledDataSource("oracle");
		Connection oracleConn = dataSource2.getConnection();
		System.out.println(oracleConn);
		Connection conn = C3P0Util.getConnection();
	}
}

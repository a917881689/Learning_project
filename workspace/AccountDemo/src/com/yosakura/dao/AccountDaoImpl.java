package com.yosakura.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yosakura.util.C3P0Util;

// dao实现类
public class AccountDaoImpl {
	// 付款人扣钱
	public int getMoney (Connection conn,String form,double money) throws SQLException {
		QueryRunner qr = new QueryRunner(); 
				C3P0Util.getQueryRunner();
		String sql = "UPDATE account SET balance= blance-? WHERE name=?";
		return qr.update(conn,sql,money,form);
	}
	// 收款人加钱
	public int saveMoney (Connection conn,String form,double money) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "UPDATE account SET balance= blance+? WHERE name=?";
		return qr.update(conn,sql,money,form);
	}
}

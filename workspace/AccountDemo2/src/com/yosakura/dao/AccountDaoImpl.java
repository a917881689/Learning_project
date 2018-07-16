package com.yosakura.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yosakura.util.C3P0Util;

// dao实现类
public class AccountDaoImpl {
	// 付款人扣钱
	public int getMoney (String form,double money) throws SQLException {
		//
		Connection conn = C3P0Util.getcurrentConnection();
		// 无参数一般是事务用
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE account SET balance= balance-? WHERE name=?";
		return qr.update(conn,sql,money,form);
	}
	// 收款人加钱
	public int saveMoney (String form,double money) throws SQLException {
		Connection conn = C3P0Util.getcurrentConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE account SET balance= balance+? WHERE name=?";
		return qr.update(conn,sql,money,form);
	}
}

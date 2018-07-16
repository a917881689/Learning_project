package com.yosakura.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.yosakura.dao.AccountDaoImpl;
import com.yosakura.util.C3P0Util;

/**
 * 业务类
 * @author Administrator
 *
 */
public class AccountServiceImpl {
	// 转账功能
	public boolean zhuanzhang (String from,String to,double money) {
		AccountDaoImpl adi = new AccountDaoImpl();
		// 付款人扣钱
		int row2 = 0;
		Connection conn = C3P0Util.getConnection();
		try {
			conn.setAutoCommit(false);
			int row1 = adi.getMoney(conn,from, money);
			// 收款人加钱		
			if (row1 > 0) {
				// 模拟银行系统崩溃
				int num = 10/0;
				row2 = adi.saveMoney(conn,to,money);
			}
			if (row1 > 0) {
				// 判断操作都成功时才能手动提交
				// 表示提交事务
				conn.commit();
			}else {
				// 处理特殊情况
				throw new SQLException();
			}
		}catch (Exception e) {
			try {
				// 表示事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("银行系统崩溃,系统正在回滚");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row2>0;
	}
}

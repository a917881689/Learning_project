package com.yulu.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.yulu.dao.AccountDao;
// 原本要注入一个Spring自带的JDBC模板，现在可以继承JdbcDaoSupport

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	/*@Resource
	private DataSource dataSource;*/
	@Autowired
	AccountDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }
	@Override
	public boolean outMoney(String from, double money) {
		String sql = "update account set money=money-? where name=?";
		int update = this.getJdbcTemplate().update(sql,money,from);
		return update == 1;
	}

	@Override
	public boolean saveMoney(String to, double money) {
		String sql = "update account set money=money+? where name=?";
		int update = this.getJdbcTemplate().update(sql,money,to);
		return update == 1;
		
	}
	// 将Spring的JDBC模板注入到数据持久层实现类中

}

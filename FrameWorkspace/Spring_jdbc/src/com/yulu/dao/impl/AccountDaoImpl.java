package com.yulu.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yulu.dao.AccountDao;
import com.yulu.domain.Account;

public class AccountDaoImpl implements AccountDao{
	// 将Spring的JDBC模板注入到数据持久层实现类中
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addAcount(Account account) {
		String sql = "insert into account(name,money) values(?,?)";
		jdbcTemplate.update(sql,account.getName(),account.getMoney());
	}

}

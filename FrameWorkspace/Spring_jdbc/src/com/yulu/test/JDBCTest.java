package com.yulu.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.dao.AccountDao;
import com.yulu.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTest {
	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	// 查询对象集合并封装
	@Test
	public void demo5() {
		String sql = "SELECT id,name,money FROM account";
		List<Account> list = jdbcTemplate.query(sql,new myRowMapper());
		for (Account account : list) {
			System.out.println(account);
		}
	}
	
	// 查询对象并封装
	@Test
	public void demo4() {
		String sql = "SELECT id,name,money FROM account WHERE id=?";
		Account obj = jdbcTemplate.queryForObject(sql,new myRowMapper(),7L);
		System.out.println(obj);
	}
	
	// 查询组函数
	@Test
	public void demo3() {
		String sql = "SELECT COUNT(*) FROM account ";
		Long result = jdbcTemplate.queryForObject(sql,Long.class);
		System.out.println(result);
	}
	
	// 查询单字段
	@Test
	public void demo2() {
		String sql = "SELECT name FROM account WHERE id=?";
		String str = jdbcTemplate.queryForObject(sql,String.class,7L);
		System.out.println(str);
	}
	
	@Test
	public void demo1() {
		accountDao.addAcount(new Account("赵云",999D));
	}
}
class myRowMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int arg1) throws SQLException {
		Account account = new Account();
		account.setId(rs.getLong("id"));
		account.setName(rs.getString("name"));
		account.setMoney(rs.getDouble("money"));
		return account;
	}
	
	
}

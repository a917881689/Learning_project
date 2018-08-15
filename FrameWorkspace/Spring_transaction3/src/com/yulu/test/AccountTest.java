package com.yulu.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {
	@Resource(name="accountService")
	private AccountService accountService;
	
	// 转账单元测试
	@Test
	public void demo1 () {
		accountService.tranferMoney("张三","李四",200);
	}
}

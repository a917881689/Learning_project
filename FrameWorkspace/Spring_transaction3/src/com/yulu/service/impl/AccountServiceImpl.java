package com.yulu.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.yulu.dao.AccountDao;
import com.yulu.service.AccountService;
// 在需要添加事务的类上添加注解
@Transactional
public class AccountServiceImpl implements AccountService{
	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	// 转账逻辑（一边扣钱，一边收钱：保存同时成功/失败）
	@Override
	public void tranferMoney(String from, String to, double money) {
		// 1.付款人扣钱
		boolean flag = accountDao.outMoney(from, money);
		// 2.收款人加钱
		if (flag) {
			int i = 1/0;
			flag = accountDao.saveMoney(to, money);
		}
		System.out.println(flag?"成功":"失败");
		
	}

}

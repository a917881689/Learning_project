package com.yulu.service;

public interface AccountService {
	/**
	 * 转账的业务逻辑方法
	 * @param from 转账人
	 * @param to 收款人
	 * @param money 转账金额
	 */
	void tranferMoney(String from,String to,double money);
}

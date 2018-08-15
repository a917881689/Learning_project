package com.yulu.dao;

public interface AccountDao {
	/**
	 * 取钱
	 * @param from 取款人
	 * @param money 金额
	 * @return 
	 */
	boolean outMoney (String from,double money);
	/**
	 * 存钱
	 * @param to 存款人
	 * @param money 金额
	 */
	boolean saveMoney (String to,double money);
}

package com.yulu.service;

import com.yulu.entity.User;

public interface UserService {
	/**
	 * 添加
	 * @param user 用户对象
	 * @return 影响的行数
	 */
	int add(User user);

	/**
	 * id查询用户
	 * @param id 用户id
	 * @return 用户对象
	 */
	User queryById(int id);

	/**
	 * 修改
	 * @param user 用户对象
	 * @return 影响的行数
	 */
	int update(User user);

	/**
	 * 删除
	 * @param id 用户id
	 * @return 影响的行数
	 */
	int delete(int id);
}

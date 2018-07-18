package com.yosakura.dao;

import java.sql.SQLException;

import com.yosakura.entity.User;

/**
 * 用户的数据持久层接口
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return !=null 用户名已存在
	 */
	User queryUserByName(String name) throws SQLException;
	/**
	 * 登录验证用户
	 * @param user
	 * @return != null 查询到用户,登录用户
	 * @throws SQLException
	 */
	User queryUserByLogin(User user) throws SQLException;
	/**
	 * 2.添加用户
	 * @param user
	 * @return 受影响的行数
	 */
	int addUser(User user) throws SQLException;
}

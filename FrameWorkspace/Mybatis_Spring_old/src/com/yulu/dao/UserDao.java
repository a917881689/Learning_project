package com.yulu.dao;

import java.util.List;

import com.yulu.entity.User;

/**
 * 用户持久层接口
 *
 */
public interface UserDao {
	/**
	 * 根据名字模糊查询
	 * @return
	 */
	List<User> findUserByName(String uname);
	Integer insertUser(User user);
}

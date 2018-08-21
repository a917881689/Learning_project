package com.yulu.service;

import java.util.List;

import com.yulu.entity.User;

public interface UserService {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	/**
	 * 根据名字模糊查询
	 * @param name
	 * @return
	 */
	List<User> findUserByName(String name);
	/**
	 * 3.根据用户和性别查询
	 * @param name
	 * @param sex
	 * @return
	 */
	List<User> findUserByNameAndSex(String name,String sex);
}

package com.yulu.dao;

import java.util.List;

import com.yulu.entity.User;

public interface UserDao {
	int insertUser(User user);
	int deleteUserById(Integer id);
	int updateUser(User user);
	User findUserById(Integer id);
	List<User> findAll();
	
}

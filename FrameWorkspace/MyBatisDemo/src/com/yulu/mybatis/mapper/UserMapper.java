package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.User;

public interface UserMapper {
	int insertUser(User user);
	int deleteUserById(Integer id);
	int updateUserById(User user);
	User queryUserById(Integer id);
	List<User> queryAll();
	
}

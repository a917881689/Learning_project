package com.yulu.mybatis.mapper;
/**
 * 接口动态代理模式
 * @author Administrator
 *
 */

import java.util.List;

import com.yulu.entity.User;

public interface UserMapper {
	/**
	 * 动态SQL多条件查询用户
	 * @param user 用户对象
	 * @return 用户对象集合
	 */
	List<User> findUser(User user);
}

package com.yulu.mybatis.mapper;

import com.yulu.entity.User;
import org.springframework.stereotype.Repository;


public interface UserMapper {
	/**
	 * 添加客户
	 * @param user 用户对象
	 * @return 影响的行数
	 */
	int add(User user);

	/**
	 * 删除
	 * @param id 用户id
	 * @return 影响的行数
	 */
	int delete(int id);

	/**
	 * 修改
	 * @param user 用户对象
	 * @return 影响的行数
	 */
	int update(User user);

	/**
	 * id查询用户
	 * @param id 用户id
	 * @return 用户对象
	 */
	User queryById(int id);

}

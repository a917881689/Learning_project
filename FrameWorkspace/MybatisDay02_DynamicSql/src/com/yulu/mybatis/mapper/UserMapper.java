package com.yulu.mybatis.mapper;
/**
 * 接口动态代理模式(代理的功能就是替代)
 * 1.接口名称与映射文件名一致，并且在同一包下
 * 2.接口的方法名与sql的id一致
 * 3.接口的形参和sql入参一致
 * 4.接口的返回值类型与sql返回结果类型一致
 */

import java.util.List;

import com.yulu.entity.User;

public interface UserMapper {
	List<User> findAll();
}

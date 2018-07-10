package com.yosakura.service.impl;

import java.sql.SQLException;

import com.yosakura.dao.impl.UserDaoImpl;
import com.yosakura.entity.User;
import com.yosakura.service.UserService;
/**
 * 用户业务逻辑层的实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	public boolean regist(User user) {
		if (user == null) {
			return false;
		}
		int rows = 0;
		try {
			UserDaoImpl udi = new UserDaoImpl();
			// 1.需要验证用户名是否存在 （调用dao的查询接口）
			User queryUser = udi.queryUserByName(user.getUname());
			// 2.不存在就可以注册了 （调用dao的添加接口）
			if (queryUser == null) {
				rows = udi.addUser(queryUser);
			}
		} catch (Exception e) {
			// 打印异常在栈中的轨迹
			e.printStackTrace();
		}
		return rows>0;
	}

	@Override
	public User login(User user) {
		User loginUser = null;
		try {
			loginUser =  new UserDaoImpl().loginUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginUser;
	}
	
}

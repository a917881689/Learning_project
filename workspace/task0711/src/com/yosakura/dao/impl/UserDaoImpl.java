package com.yosakura.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yosakura.Util.C3P0Util;
import com.yosakura.Util.SqlUtil;
import com.yosakura.dao.UserDao;
import com.yosakura.entity.User;


/**
 * 用户数据持久层的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public User queryUserByName(String name) throws SQLException{
		// JDBC(mysql+c3p0+dbutils)
		Object[] objArray = {name};
		// 获取查询对象
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT user_id,user_name,pwd,id_card,mobile,email,type  FROM t_user WHERE user_name=?";
		// 创建用于接收结果的user对象
		User user = null;
		try {
			// 调用qr的查询方法
			user = qr.query(sql,new BeanHandler<User>(User.class),objArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User loginUser(User user) throws SQLException {
		Object[] objArray = SqlUtil.getObjAttr(user);
		// 获取查询对象
		String sql = "SELECT user_id,user_name,pwd,id_card,mobile,email,type FROM t_user WHERE user_name=? AND pwd=? AND type=?";
		QueryRunner qr = C3P0Util.getQueryRunner();
		// 创建用于接收结果的user对象
		user = null;
		try {
			// 调用qr的查询方法
			user = qr.query(sql,new BeanHandler<User>(User.class),objArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public int addUser(User user) throws SQLException{
		Object [] objArray =  SqlUtil.getObjAttr(user);
		String sql = "INSERT INTO t_user(user_id,user_name,pwd,id_card,mobile,email,type) VALUES(t_user_id_seq.nextval,?,?,?,?,?,?)";
		// 获取查询对象
		QueryRunner qr = C3P0Util.getQueryRunner();
		// 调用qr的update更新方法
        int result = qr.update(sql,new BeanHandler<User>(User.class),objArray);
        return result; 
	}
	
}

package com.yosakura.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yosakura.dao.UserDao;
import com.yosakura.entity.User;
import com.yosakura.util.C3P0Util;
import com.yosakura.util.SqlUtil;

/**
 * 用户数据持久层的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	// 查询用户名是否存在
	@Override
	public User queryUserByName(String name) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,uname,pwd,sex,birthday,idcard,email,mobile,address,utype FROM amz_user WHERE uname=?";
		return qr.query(sql, new BeanHandler<User>(User.class),name);
	}
	
	// 查询邮箱是否存在
	@Override
	public User queryUserByEmail(String email) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,uname,pwd,sex,birthday,idcard,email,mobile,address,utype FROM amz_user WHERE email=?";
		return qr.query(sql, new BeanHandler<User>(User.class),email);
	}
	
	// 添加用户
	@Override
	public int addUser(User user) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "INSERT INTO amz_user(uname,pwd,sex,birthday,idcard,email,mobile,address,utype) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] objArray = SqlUtil.getObjAttr(user);
		return qr.update(sql,objArray);
		
	}
	// 登录验证用户
	@Override
	public User queryUserByLogin(User user) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,uname,pwd,sex,birthday,idcard,email,mobile,address,utype FROM amz_user WHERE uname=? AND pwd=? ";
		Object[] objArray = SqlUtil.getObjAttr(user);
		return qr.query(sql,new BeanHandler<User>(User.class),objArray);
	}

	public User getpwd(String userName, String uName, String email) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,uname,pwd,sex,birthday,idcard,email,mobile,address,utype FROM amz_user WHERE uname=? AND email=? ";
		return qr.query(sql,new BeanHandler<User>(User.class),userName,email);
	}
	
	
}
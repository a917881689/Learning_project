package com.yosakura.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.yosakura.Util.ConnectionFactory;
import com.yosakura.Util.JDBCUtil;
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
		String sql = "SELECT user_id,user_name,pwd,id_card,mobile,email,type  FROM t_user WHERE user_name=?";
		User user = null;
		try {
			user = JDBCUtil.singQuery(sql, objArray,(result) -> new User(Long.parseLong(result.getString("user_id")),result.getString("user_name"),result.getString("pwd"),result.getString("id_card"),
					result.getString("mobile"),result.getString("email"),Integer.parseInt(result.getString("type"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User loginUser(User user) throws SQLException {
		Object[] objArray = SqlUtil.getObjAttr(user);
		String sql = "SELECT user_id,user_name,pwd,id_card,mobile,email,type FROM t_user WHERE user_name=? AND pwd=? AND type=?";
		user = null;
		try {
			user = JDBCUtil.singQuery(sql, objArray,(result) -> new User(Long.parseLong(result.getString("user_id")),result.getString("user_name"),result.getString("pwd"),result.getString("id_card"),
					result.getString("mobile"),result.getString("email"),Integer.parseInt(result.getString("type"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public int addUser(User user) throws SQLException{
		String sql = "INSERT INTO t_user(user_id,user_name,pwd,id_card,mobile,email,type) VALUES(t_user_id_seq.nextval,?,?,?,?,?,?)";
		Object [] objArray =  SqlUtil.getObjAttr(user);
        Connection conn = ConnectionFactory.getConnection();
        int result = JDBCUtil.update(sql, objArray, conn);
        ConnectionFactory.close(conn);
        return result; 
	}
	
}

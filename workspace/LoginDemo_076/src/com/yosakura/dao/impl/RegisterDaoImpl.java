package com.yosakura.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.yosakura.Util.ConnectionFactory;
import com.yosakura.Util.JDBCUtil;
import com.yosakura.Util.SqlUtil;
import com.yosakura.dao.RegisterDao;
import com.yosakura.entity.User;

public class RegisterDaoImpl implements RegisterDao{

	@Override
	public int addUser(String sql, User user) throws SQLException {
		Object [] objArray =  SqlUtil.getObjAttr(user);
        Connection conn = ConnectionFactory.getConnection();
        int result = JDBCUtil.update(sql, objArray, conn);
        ConnectionFactory.close(conn);
        return result; 
	}
	
}

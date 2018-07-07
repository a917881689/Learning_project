package com.yosakura.web.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.yosakura.web.Util.ConnectionFactory;
import com.yosakura.web.Util.JDBCUtil;
import com.yosakura.web.Util.SqlUtil;
import com.yosakura.web.dao.RegisterDao;
import com.yosakura.web.entity.User;

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

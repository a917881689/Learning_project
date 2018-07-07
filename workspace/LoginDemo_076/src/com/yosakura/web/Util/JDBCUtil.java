package com.yosakura.web.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static int update (String sql,Object[] array,Connection conn) throws SQLException {
		PreparedStatement patmt = conn.prepareStatement(sql);
		JDBCUtil.unite(array,patmt);
		int resultSet = patmt.executeUpdate(); 
		ConnectionFactory.close(patmt);
		return resultSet;
	}
	public static <T>T singQuery (String sql, Object[] array,ResultSetHandler<T> handler) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement patmt = conn.prepareStatement(sql);
		JDBCUtil.unite(array, patmt);
		ResultSet resultSet = patmt.executeQuery();
		T obj = null;
		if (resultSet.next()) {
			obj = handler.handlerRow(resultSet);
		}
		ConnectionFactory.close(conn,patmt,resultSet);
		return obj;
	}
    private static void unite (Object[] array,PreparedStatement patmt) throws SQLException {
        if (array != null) {
            for (int i = 0,j = 1; i < array.length;i++) {
                if (array[i] != null) {
                    patmt.setObject(j,array[i]);
                    j++;
                }
            }
        }
    }
}
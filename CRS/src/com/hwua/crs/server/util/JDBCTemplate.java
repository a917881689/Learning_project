package com.hwua.crs.server.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 11:34
 */
public class JDBCTemplate {

    /**
     * 增删改SQL的简单封装
     * @param sql sql语句
     * @param array 条件值 数组
     * @param conn 连接对象
     * @return 影响行数
     * @throws SQLException
     */
    public static int update (String sql,Object[] array,Connection conn) throws SQLException {
        PreparedStatement patmt = conn.prepareStatement(sql);
        preparedStatementAdd(array,patmt);
        int result = patmt.executeUpdate();
        ConnectionFactory.close(patmt);
        return result;
    }

    /**
     * 查询返回单条语句
     * @param sql sql语句
     * @param array 条件值 数组
     * @param handler 行处理对象
     * @param <T> 对象类型
     * @return 普通对象POJO
     * @throws SQLException
     */
    public static <T> T singQuery (String sql, Object[] array,ResultSetHandler<T> handler) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement patmt = conn.prepareStatement(sql);
        ResultSet result;
        T obj = null;
        preparedStatementAdd(array,patmt);
        result = patmt.executeQuery();
        if (result.next()) {
            obj = handler.handlerRow(result);
        }
        ConnectionFactory.close(conn,patmt,result);
        return obj;
    }
    private static void preparedStatementAdd (Object[] array,PreparedStatement patmt) throws SQLException {
        if (array != null) {
            for (int i = 0,j = 1; i < array.length;i++) {
                if (array[i] != null) {
                    patmt.setObject(j,array[i]);
                    j++;
                }
            }
        }
    }

    /**
     * 查询返回多行语句
     * @param sql sql语句
     * @param array 条件值 数组
     * @param handler 行处理对象
     * @param <T> 对象类型
     * @return 对象数组
     * @throws SQLException
     */
    public static <T> List<T> query (String sql, Object[] array,ResultSetHandler<T> handler) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement patmt = conn.prepareStatement(sql);
        ResultSet result;
        List<T> list = new ArrayList<>();
        preparedStatementAdd(array,patmt);
        result = patmt.executeQuery();
        if (result != null) {
            while (result.next()) {
                T obj = handler.handlerRow(result);
                list.add(obj);
            }
        }

        ConnectionFactory.close(conn,patmt,result);
        return list;

    }
}

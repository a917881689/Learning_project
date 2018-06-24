package com.hwua.crs.server.dao;

import com.hwua.crs.server.util.InfoValue;

import java.sql.Connection;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 10:09
 */
public interface IUserDao {
    /**
     * 查询的的sql封装
     * @param sql:sql语句
     * @param array:条件对象数组
     * @param info:查询表对应的标识
     * @return 返回查询的单个对象的json字符串
     */
    String singQuery (String sql,Object[] array,InfoValue info);

    /**
     * 查询的的sql封装
     * @param sql:sql语句
     * @param array:条件对象数组
     * @param info:查询表对应的标识
     * @return 返回查询的对象集合的json字符串
     */
    String query (String sql,Object[] array,InfoValue info);

    /**
     * 修改sql的封装
     * @param sql:sql语句
     * @param array:条件对象数组
     * @param conn 连接用于事务控制
     * @return 返回修改受影响的行数
     */
    int update (String sql, Object[] array, Connection conn);
}

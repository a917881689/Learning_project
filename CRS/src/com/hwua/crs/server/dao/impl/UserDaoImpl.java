package com.hwua.crs.server.dao.impl;

import com.alibaba.fastjson.JSON;
import com.hwua.crs.server.entity.*;
import com.hwua.crs.server.dao.IUserDao;
import com.hwua.crs.server.util.ConnectionFactory;
import com.hwua.crs.server.util.InfoValue;
import com.hwua.crs.server.util.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 10:09
 */
public class UserDaoImpl implements IUserDao {
    private UserDaoImpl() {}
    private static class SingletonHolder  {
        private final static UserDaoImpl USER_DAO_IMPL = new UserDaoImpl();
    }
    public static UserDaoImpl getConnection () {
        return SingletonHolder.USER_DAO_IMPL;
    }
    @Override
    public String singQuery (String sql,Object[] array,InfoValue info) {
        String str = null;
        try {
            switch (info) {
                case CAR:
                    Car car = JDBCTemplate.singQuery(sql,array,new Car());
                    str = JSON.toJSONString(car);
                    break;
                case BRAND:
                    Brand brand = JDBCTemplate.singQuery(sql,array,new Brand());
                    str = JSON.toJSONString(brand);
                    break;
                case CATEGORY:
                    CarCategory category = JDBCTemplate.singQuery(sql,array,new CarCategory());
                    str = JSON.toJSONString(category);
                    break;
                case RECORD:
                    Record record = JDBCTemplate.singQuery(sql,array,new Record());
                    str = JSON.toJSONString(record);
                    break;
                case USER:
                    User user = JDBCTemplate.singQuery(sql,array,new User());
                    str = JSON.toJSONString(user);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public String query (String sql,Object[] array,InfoValue info) {
        String str = null;
        try {
            switch (info) {
                case CAR:
                    List<Car> car = JDBCTemplate.query(sql,array,new Car());
                    str = JSON.toJSONString(car);
                    break;
                case BRAND:
                    List<Brand> brand = JDBCTemplate.query(sql,array,new Brand());
                    str = JSON.toJSONString(brand);
                    break;
                case CATEGORY:
                    List<CarCategory> category = JDBCTemplate.query(sql,array,new CarCategory());
                    str = JSON.toJSONString(category);
                    break;
                case RECORD:
                    List<Record> record = JDBCTemplate.query(sql,array,new Record());
                    str = JSON.toJSONString(record);
                    break;
                case USER:
                    List<User> user = JDBCTemplate.query(sql,array,new User());
                    str = JSON.toJSONString(user);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public int update (String sql,Object[] array,Connection conn) {
        int result = -1;
        try {
            result = JDBCTemplate.update(sql,array,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

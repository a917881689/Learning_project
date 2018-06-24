package com.hwua.crs.server.service.impl;


import com.alibaba.fastjson.JSON;
import com.hwua.crs.server.dao.impl.UserDaoImpl;
import com.hwua.crs.server.entity.*;
import com.hwua.crs.server.service.IUserService;
import com.hwua.crs.server.util.ConnectionFactory;
import com.hwua.crs.server.util.InfoValue;
import com.hwua.crs.server.util.SqlUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 10:36
 */
public class IUserServiceImpl implements IUserService {

    private UserDaoImpl userDao = UserDaoImpl.getConnection();
    @Override
    public InfoValue queryName (String sql,Object obj,InfoValue infoValue) {
        User user = JSON.parseObject(JSON.toJSONString(obj),User.class);
        if (!(user.getSex()  >=0) || !(user.getSex() <= 1)) {
            return InfoValue.SEX_ERROR;
        }
        Object[] array = {user.getUsername()};
        String userInfo = userDao.singQuery(sql,array,infoValue);
        User result = JSON.parseObject(userInfo,User.class);
        if (result != null) {
            return InfoValue.ACCOUNT_REPEAT;
        }else {
            return InfoValue.ACCOUNT_NO_REPEAT;
        }
    }
    @Override
    public String query(String sql,Object obj,InfoValue infoValue) {
        return userDao.query(sql,SqlUtil.transformation(obj,infoValue),infoValue);
    }
    @Override
    public String update (String sql,Object obj,InfoValue infoValue) {
        Object[] array = SqlUtil.transformation(obj,infoValue);
        Connection conn = ConnectionFactory.getConnection();
        return userDao.update(sql,array,conn)+"";
    }
    @Override
    public String update(String[] sql,Object[] obj,InfoValue[] info) {
        Connection conn = ConnectionFactory.getConnection();
        int count = 0;
        try {
            conn.setAutoCommit(false);
            for (int i = 0;i < sql.length;i++) {
                Object[] array = SqlUtil.transformation(obj[i],info[i]);
                count += userDao.update(sql[i],array,conn);
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            ConnectionFactory.close(conn);
        }
        return count+"";
    }
    @Override
    public String update (String sql, List<Car> carList,InfoValue infoValue) {
        Connection conn = ConnectionFactory.getConnection();
        int count = 0;
        try {
            conn.setAutoCommit(false);
            for (Car car:carList) {
                Object[] array = SqlUtil.transformation(car,infoValue);
                count += userDao.update(sql,array,conn);
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            ConnectionFactory.close(conn);
        }
        return count+"";
    }

}

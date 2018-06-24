package com.hwua.crs.server.service;

import com.hwua.crs.server.entity.Car;
import com.hwua.crs.server.util.InfoValue;

import java.util.List;

/**
 * @Author: yoSakura
 * @Date: 2018/6/13 10:31
 */
public interface IUserService {
    /**
     * 查看用户信息是否符合标准
     * @param sql sql语句
     * @param obj 条件对象
     * @param infoValue 对象标识
     * @return 标识信息
     */
    InfoValue queryName(String sql,Object obj,InfoValue infoValue);
    /**
     * 查询语句
     * @param sql sql语句
     * @param obj 条件对象
     * @param infoValue 对象标识
     * @return 查询的集合的JSON字符串
     */
    String query(String sql,Object obj,InfoValue infoValue);
    /**
     * 修改语句
     * @param sql sql语句
     * @param obj 条件对象
     * @param infoValue 对象标识
     * @return 修改行数
     */
    String update (String sql,Object obj,InfoValue infoValue);
    /**
     * 多重修改语句
     * @param sql sql语句数组
     * @param obj 条件对象数组
     * @param info 对象标识数组
     * @return 修改行数
     */
    String update(String[] sql,Object[] obj,InfoValue[] info);
    String update (String sql,List<Car> carList,InfoValue infoValue);

}

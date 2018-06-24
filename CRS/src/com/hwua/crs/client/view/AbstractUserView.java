package com.hwua.crs.client.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hwua.crs.client.entity.*;
import com.hwua.crs.client.Client;
import com.hwua.crs.client.util.InfoValue;
import com.hwua.crs.client.util.SqlUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractUserView {
    public User user;
    public AbstractUserView(User user) {
        this.user = user;
        this.ini();
    }
    public AbstractUserView() {
        this.ini();
    }
    public static Map<Long,Brand> brandMap = new HashMap<>(16);
    public static Map<Long,CarCategory> carCategoryMap = new HashMap<>(16);
    public static Map<Long,User> userMap = new HashMap<>(16);
    public static Map<Long,Record> recordMap = new HashMap<>(16);
    public static Map<Long,Car> carMap = new HashMap<>(16);
    public Car getCar(List<Car> list) {
        if (list.size() > 0 && list != null) {
            return list.get(0);
        }
        return null;
    }
    public Record getRecord(List<Record> list) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public List<Car> carUpdate () {
        String sql = SqlUtil.querySql("SELECT * FROM t_car",InfoValue.CAR);
        List<Car> list = JSON.parseArray(this.sqlLink(sql),Car.class);
        for (Car obj: list) {
            carMap.put(obj.getId(),obj);
        }
        return list;
    }
    public List<User> userUpdate () {
        String sql = SqlUtil.querySql("SELECT * FROM t_user",InfoValue.USER);
        List<User> list = JSON.parseArray(this.sqlLink(sql),User.class);
        for (User obj: list) {
            userMap.put(obj.getId(),obj);
        }
        return list;
    }
    public List<Record> recordUpdate () {
        String sql = SqlUtil.querySql(InfoValue.QUERY_RECORD.getInfo(),InfoValue.RECORD);
        List<Record> list = JSON.parseArray(this.sqlLink(sql),Record.class);
        for (Record obj: list) {
            recordMap.put(obj.getId(),obj);
        }
        return list;
    }
    public List<Brand> brandUpdate () {
        String sql = SqlUtil.querySql("SELECT * FROM t_brand",InfoValue.BRAND);
        List<Brand> list = JSON.parseArray(this.sqlLink(sql),Brand.class);
        for (Brand obj: list) {
            brandMap.put(obj.getId(),obj);
        }
        return list;
    }
    public List<CarCategory> categoryUpdate () {
        String sql = SqlUtil.querySql("SELECT * FROM t_category",InfoValue.CATEGORY);
        List<CarCategory> list = JSON.parseArray(this.sqlLink(sql),CarCategory.class);
        for (CarCategory obj: list) {
            carCategoryMap.put(obj.getId(),obj);
        }
        return list;
    }
    public String sqlLink (String sql,Object obj,Object obj2) {
        Client client = new Client();
        String json = JSON.toJSONString(obj,SerializerFeature.WriteMapNullValue,SerializerFeature.SortField);
        String json2 = JSON.toJSONString(obj2,SerializerFeature.WriteMapNullValue,SerializerFeature.SortField);
        return client.link(sql,json,json2);
    }
    public String sqlLink (String sql,Object obj) {
        return this.sqlLink(sql,obj,null);
    }
    public String sqlLink (String sql) {
        return this.sqlLink(sql,null,null);
    }
    public void ini () {
        this.brandUpdate();
        this.categoryUpdate();
    }
    /**
     * 根据查询语句返回对象集合
     * @param sql 查询语句
     * @param car 条件对象
     * @return 对象集合
     */
    public abstract List<Car> queryCar(String sql,Car car);
    /**
     * 根据查询语句返回对象集合
     * @param sql 查询语句
     * @param record 条件对象
     * @return 对象集合
     */
    public abstract List<Record> queryRecord(String sql,Record record);
    /**
     * 根据对象集合信息显示到屏幕
     * @param carList 对象集合
     */
    public abstract void showCar (List<Car> carList);
    /**
     * 根据对象集合信息显示到屏幕
     * @param recordList 对象集合
     */
    public abstract void showRecord(List<Record> recordList);
}

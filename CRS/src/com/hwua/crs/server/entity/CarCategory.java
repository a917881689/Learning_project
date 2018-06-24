package com.hwua.crs.server.entity;

import com.hwua.crs.server.util.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: yoSakura
 * @Date: 2018/6/14 16:44
 */
public class CarCategory implements ResultSetHandler<CarCategory> {
    private long id;
    private String name;

    public CarCategory() {
    }
    public CarCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public CarCategory handlerRow(ResultSet result) throws SQLException {
        return new CarCategory(result.getLong("id"),result.getString("name"));
    }
}

package com.hwua.crs.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.hwua.crs.server.util.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: yoSakura
 * @Date: 2018/6/14 16:18
 */
public class Car implements ResultSetHandler<Car> {
    @JSONField(name = "d")
    private long id;
    @JSONField(name = "e")
    private String carNumber;
    @JSONField(name = "f")
    private long brandId;
    @JSONField(name = "g")
    private String model;
    @JSONField(name = "h")
    private String color;
    @JSONField(name = "i")
    private long categoryId;
    @JSONField(name = "j")
    private String comments;
    @JSONField(name = "k")
    private double price;
    @JSONField(name = "a")
    private double rent;
    @JSONField(name = "b")
    private int status;
    @JSONField(name = "c")
    private int useable;

    public Car() {}
    public Car(long id) {
        this(id,-1);
    }
    public Car(long id,double rent) {
        this(id,null,-1,null,null,-1,null,-1,rent,-1,-1);
    }
    public Car(long id,int useable) {
        this(id,null,-1,null,null,-1,null,-1,-1,-1,useable);
    }
    public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String comments, double price, double rent, int status, int useable) {
        this.id = id;
        this.carNumber = carNumber;
        this.brandId = brandId;
        this.model = model;
        this.color = color;
        this.categoryId = categoryId;
        this.comments = comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUseable(int useable) {
        this.useable = useable;
    }

    public long getId() {
        return id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public long getBrandId() {
        return brandId;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getComments() {
        return comments;
    }

    public double getPrice() {
        return price;
    }

    public double getRent() {
        return rent;
    }

    public int getStatus() {
        return status;
    }

    public int getUseable() {
        return useable;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", brandId=" + brandId +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", categoryId=" + categoryId +
                ", comments='" + comments + '\'' +
                ", price=" + price +
                ", rent=" + rent +
                ", status=" + status +
                ", useable=" + useable +
                '}';
    }

    @Override
    public Car handlerRow(ResultSet result) throws SQLException {
        return new Car(result.getLong("id"),result.getString("car_number"),
                result.getLong("brand_id"),result.getString("model"),
                result.getString("color"),result.getLong("category_id"),
                result.getString("t_comments"),result.getDouble("price"),
                result.getDouble("rent"),result.getInt("status"),
                result.getInt("useable"));
    }
}

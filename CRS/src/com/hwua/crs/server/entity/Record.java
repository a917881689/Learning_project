package com.hwua.crs.server.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.hwua.crs.server.util.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: yoSakura
 * @Date: 2018/6/14 16:46
 */
public class Record implements ResultSetHandler<Record> {
    @JSONField(name = "d")
    private long id;
    @JSONField(name = "e")
    private long userId;
    @JSONField(name = "f")
    private long carId;
    @JSONField(name = "a")
    private String startDate;
    @JSONField(name = "b")
    private String returnDate;
    @JSONField(name = "c")
    private double payment;

    public Record() {}
    public Record(long userId,long carId,String startDate) {
        this(-1,userId,carId,startDate,null,-1);
    }
    public Record(long id) {
        this(id,-1);
    }
    public Record(long id,String returnDate,double payment) {
        this(id,-1,-1,null,returnDate,payment);
    }
    public Record(long userId,long carId) {
        this(-1,userId,carId,null,null,-1);
    }

    public Record(long id, long userId, long carId, String startDate, String returnDate, double payment) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", startDate='" + startDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", payment=" + payment +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public long getId() {

        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getCarId() {
        return carId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public Record handlerRow(ResultSet result) throws SQLException {
        return new Record(result.getLong("id"),result.getLong("user_id"),
                result.getLong("car_id"),result.getString("start_date"),
                result.getString("return_date"),result.getDouble("payment"));
    }
}

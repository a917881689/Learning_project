package com.hwua.crs.client.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.hwua.crs.server.util.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User{
    @JSONField(name = "a")
    private long id;
    @JSONField(name = "b")
    private String username;
    @JSONField(name = "c")
    private String password;
    @JSONField(name = "d")
    private int sex;
    @JSONField(name = "e")
    private String idNumber;
    @JSONField(name = "f")
    private String tel;
    @JSONField(name = "g")
    private String address;
    @JSONField(name = "h")
    private int type;

    public User() {}
    public User(String username) {
        this(-1,username,null,-1,null,null,null,-1);
    }
    public User(String username,String password) {
        this(-1,username,password,-1,null,null,null,-1);
    }
    public User(long id, String username, String password, int sex, String idNumber, String tel, String address, int type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.idNumber = idNumber;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", 用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 性别=" + sex +
                ", 身份证号码='" + idNumber + '\'' +
                ", 电话='" + tel + '\'' +
                ", 地址='" + address + '\'' +
                ", 权限=" + type +
                '}';
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }
}

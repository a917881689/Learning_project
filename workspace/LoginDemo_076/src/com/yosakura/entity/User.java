package com.yosakura.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yosakura.Util.ResultSetHandler;

public class User implements ResultSetHandler<User>{
	private long userId;
	private String userName;
	private String pwd;
	private String idCard;
	private String mobile;
	private String email;
	private int type;	
	public User() {}
	
	public User(String userName, String pwd,int type) {
		this(-1,userName,pwd,null,null,null,type);
	}
	public User(String userName, String pwd, String idCard, String mobile, String email,int type) {
		this(-1,userName,pwd,idCard,mobile,email,type);
	}
	public User(long userId,String userName, String pwd, String idCard, String mobile, String email,int type) {
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.idCard = idCard;
		this.mobile = mobile;
		this.email = email;
		this.type = type;
	}
	@Override
	public User handlerRow(ResultSet result) throws SQLException {
		return new User(Long.parseLong(result.getString("user_id")),result.getString("user_name"),result.getString("pwd"),result.getString("id_card"),
				result.getString("mobile"),result.getString("email"),Integer.parseInt(result.getString("type")));
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}

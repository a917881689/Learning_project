package com.yosakura.entity;

import java.util.Date;

public class User {
	private Long id;
	private String uname;
	private String pwd;
	private String sex;
	private Date birthday;
	public User() {
		super();
	}
	public User(Long id, String uname, String pwd, String sex, Date birthday) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
	

}

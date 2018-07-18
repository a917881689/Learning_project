package com.yosakura.entity;

public class User {
	private long id;
	private String uname;
	private String pwd;
	private String idCard;
	private String mobile;
	private String email;
	private int utype;
	
	public User() {
		super();
	}
	
	public User(String uname, String pwd, int utype) {
		this.id = -1;
		this.uname = uname;
		this.pwd = pwd;
		this.idCard = null;
		this.mobile = null;
		this.email = null;
		this.utype = utype;
	}

	public User(String uname, String pwd, String idCard, String mobile, String email, int utype) {
		super();
		this.id = -1;
		this.uname = uname;
		this.pwd = pwd;
		this.idCard = idCard;
		this.mobile = mobile;
		this.email = email;
		this.utype = utype;
	}
	public User(long id, String uname, String pwd, String idCard, String mobile, String email, int utype) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.idCard = idCard;
		this.mobile = mobile;
		this.email = email;
		this.utype = utype;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", idCard=" + idCard + ", mobile=" + mobile
				+ ", email=" + email + ", utype=" + utype + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getUtype() {
		return utype;
	}
	public void setUtype(int utype) {
		this.utype = utype;
	}
	
	
	
}

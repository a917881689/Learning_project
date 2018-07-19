package com.yosakura.entity;

public class User {
	private Long id;
	private String uname;
	private String pwd;
	public int utype;
	public int getUtype() {
		return utype;
	}

	public void setUtype(int utype) {
		this.utype = utype;
	}

	public User(Long id, String uname, String pwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
	}
	
	public User(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	private User(Long id, String uname){
		super();
		this.id = id;
		this.uname = uname;
	}

	public User() {
		super();
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + "]";
	}

	protected String introduce () {
		System.out.println("我是"+this.uname);
		return "mmp";
	}
}

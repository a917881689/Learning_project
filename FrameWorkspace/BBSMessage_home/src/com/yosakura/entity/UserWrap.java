package com.yosakura.entity;

public class UserWrap {
	private Long id;
	private String uname;
	public UserWrap(Long id, String uname) {
		super();
		this.id = id;
		this.uname = uname;
	}
	public UserWrap() {
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
	@Override
	public String toString() {
		return "UserWrap [id=" + id + ", uname=" + uname + "]";
	}
	
}

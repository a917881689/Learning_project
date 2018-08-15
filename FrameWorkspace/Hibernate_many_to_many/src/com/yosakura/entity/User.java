package com.yosakura.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 处理多对多关系方法,拆分成两个一对多方法
 */
public class User {
	// 客户编号
	private Long user_id;
	private String user_code;
	private String user_name;
	private String user_password;
	private String user_state;
	private Set<Role> roles = new HashSet<>();
	public Set<Role> getRoles() {
		return roles;
	}
	public User(String user_name) {
		super();
		this.user_name = user_name;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User(Long user_id, String user_code, String user_name, String user_password, String user_state,
			Set<Role> roles) {
		super();
		this.user_id = user_id;
		this.user_code = user_code;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_state = user_state;
		this.roles = roles;
	}
	public User() {
		super();
	}
	public User(Long user_id, String user_code, String user_name, String user_password, String user_state) {
		super();
		this.user_id = user_id;
		this.user_code = user_code;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_state = user_state;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_code=" + user_code + ", user_name=" + user_name + ", user_password="
				+ user_password + ", user_state=" + user_state + "]";
	}
	
	
}

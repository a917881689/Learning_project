package com.yosakura.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个客户对应多个联系人，一个联系人只能对应一个客户
 * 思考：如何存放多个
 * 
 *
 */
public class Role {
	// 联系人编号(主键)
	private Long role_id;
	// 联系人姓名
	private String role_name;
	// 联系人性别
	private String role_memo;
	private Set<User> users = new HashSet<>();
	
	public Role() {
		super();
	}
	public Role(String role_name) {
		super();
		this.role_name = role_name;
	}
	public Role(Long role_id, String role_name, String role_memo, Set<User> users) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_memo = role_memo;
		this.users = users;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_memo() {
		return role_memo;
	}
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_memo=" + role_memo + ", users=" 
				+ "]";
	}

	
}

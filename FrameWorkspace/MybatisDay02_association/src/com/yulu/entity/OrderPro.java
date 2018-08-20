package com.yulu.entity;

public class OrderPro extends Order{
	private String username;
	private String address;
	public OrderPro() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderPro [username=" + username + ", address=" + address + ", getId()=" + getId() + ", getUserId()="
				+ getUserId() + ", getNumber()=" + getNumber() + ", getCreateTime()=" + getCreateTime() + ", getNote()="
				+ getNote() + "]";
	}
	
	
	
}

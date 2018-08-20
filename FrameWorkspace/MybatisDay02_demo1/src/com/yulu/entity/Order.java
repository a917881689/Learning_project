package com.yulu.entity;
/**
 * 订单类
 *
 */

import java.util.Date;

public class Order {
	/**
	 * 订单的自然主键
	 */
	private Integer id;
	/**
	 * 订单对应的用户id
	 */
	private Integer userId;
	/**
	 * 订单号
	 */
	private String number;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 详情
	 */
	private String note;
	/**
	 * 面向对象：订单属于用户
	 */
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", number=" + number + ", createTime=" + createTime
				+ ", note=" + note + "]";
	}
	
}

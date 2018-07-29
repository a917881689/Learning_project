package com.yosakura.entity;

import java.math.BigDecimal;

public class OrderModel {
	private Long id;
	private String orderTime;
	private BigDecimal totalPrice;
	private Integer pnum;
	private Product pro;
	public OrderModel() {
		super();
	}
	public OrderModel(Long id, String orderTime, BigDecimal totalPrice, Integer pnum, Product pro) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.pnum = pnum;
		this.pro = pro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", orderTime=" + orderTime + ", totalPrice=" + totalPrice + ", pnum=" + pnum
				+ ", pro=" + pro + "]";
	}

}

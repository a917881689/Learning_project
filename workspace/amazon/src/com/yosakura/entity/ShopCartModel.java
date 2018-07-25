package com.yosakura.entity;

public class ShopCartModel {
	private Product pro;
	private Integer pnum;
	private Long sid;
	public ShopCartModel() {
		super();
	}
	public ShopCartModel(Product pro, Integer pnum) {
		super();
		this.pro = pro;
		this.pnum = pnum;
	}
	public ShopCartModel( Product pro, Integer pnum,Long sid) {
		super();
		this.pro = pro;
		this.pnum = pnum;
		this.sid = sid;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "ShopCartModel [pro=" + pro + ", pnum=" + pnum + ", sid=" + sid + "]";
	}
	
	
	
	
}

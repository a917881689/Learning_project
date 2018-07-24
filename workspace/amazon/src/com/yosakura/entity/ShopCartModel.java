package com.yosakura.entity;

public class ShopCartModel {
	private Product pro;
	private String pnum;
	public ShopCartModel() {
		super();
	}
	public ShopCartModel(Product pro, String pnum) {
		super();
		this.pro = pro;
		this.pnum = pnum;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "ShopCartModel [pro=" + pro + ", pnum=" + pnum + "]";
	}
	
}

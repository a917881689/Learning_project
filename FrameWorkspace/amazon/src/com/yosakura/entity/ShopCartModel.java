package com.yosakura.entity;

public class ShopCartModel {
	private Product pro;
	private Shop shop;
	public ShopCartModel() {
		super();
	}
	public ShopCartModel(Product pro, Shop shop) {
		super();
		this.pro = pro;
		this.shop = shop;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "ShopCartModel [pro=" + pro + ", shop=" + shop + "]";
	}
	
	
	
	
	
	
}

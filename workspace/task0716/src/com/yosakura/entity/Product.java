package com.yosakura.entity;

public class Product {
	private long id;
	private String brand;
	private String memo;
	private double price;
	private String img;
	public Product() {
		super();
	}
	public Product(long id, String brand, String memo, double price, String img) {
		super();
		this.id = id;
		this.brand = brand;
		this.memo = memo;
		this.price = price;
		this.img = img;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", memo=" + memo + ", price=" + price + ", img=" + img + "]";
	}
	
}

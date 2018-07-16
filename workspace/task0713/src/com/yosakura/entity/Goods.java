package com.yosakura.entity;

public class Goods {
	private long gId;
	private String gName;
	private long typeId;
	private double price;
	public Goods() {
		super();
	}
	public Goods(long gId, String gName, long typeId, double price) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.typeId = typeId;
		this.price = price;
	}
	public Goods(String gName, long typeId, double price) {
		this.gId = -1;
		this.gName = gName;
		this.typeId = typeId;
		this.price = price;
	}
	public Goods(String gName, long typeId) {
		this.gId = -1;
		this.gName = gName;
		this.typeId = typeId;
		this.price = -1;
	}
	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", gName=" + gName + ", typeId=" + typeId + ", price=" + price + "]";
	}
	public long getgId() {
		return gId;
	}
	public void setgId(long gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

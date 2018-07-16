package com.yosakura.entity;

public class GType {
	private long tId;
	private String tName;
	@Override
	public String toString() {
		return "GType [tId=" + tId + ", tName=" + tName + "]";
	}
	public GType(long tId, String tName) {
		super();
		this.tId = tId;
		this.tName = tName;
	}
	public GType() {
		super();
	}
	public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	
}

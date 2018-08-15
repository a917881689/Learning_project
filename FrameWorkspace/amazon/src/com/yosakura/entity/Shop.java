package com.yosakura.entity;

public class Shop {
	private Long id;
	private Long pid;
	private Integer pnum;
	private Long uid;
	
	public Shop() {
		super();
	}
	public Shop(Long pid, Integer pnum, Long uid) {
		super();
		this.pid = pid;
		this.pnum = pnum;
		this.uid = uid;
	}
	public Shop(Long pid, Integer pnum) {
		super();
		this.pid = pid;
		this.pnum = pnum;
	}
	public Shop(Long id, Long pid, Integer pnum, Long uid) {
		super();
		this.id = id;
		this.pid = pid;
		this.pnum = pnum;
		this.uid = uid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", pid=" + pid + ", pnum=" + pnum + ", uid=" + uid + "]";
	}
	
	
}

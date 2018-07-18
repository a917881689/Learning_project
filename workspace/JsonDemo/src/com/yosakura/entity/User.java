package com.yosakura.entity;

public class User {
	private Long id;
	private String uname;
	private Double salary;
	public User() {
		super();
	}
	public User(Long id, String uname, Double salary) {
		super();
		this.id = id;
		this.uname = uname;
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", salary=" + salary + "]";
	}
	
	
}

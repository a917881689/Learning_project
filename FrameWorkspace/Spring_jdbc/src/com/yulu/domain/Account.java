package com.yulu.domain;

public class Account {
	private Long id;
	private String name;
	private Double money;
	
	public Account() {
		super();
	}
	
	public Account(String name, Double money) {
		super();
		this.name = name;
		this.money = money;
	}

	public Account(Long id, String name, Double money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
}

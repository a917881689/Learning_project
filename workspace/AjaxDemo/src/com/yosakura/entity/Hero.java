package com.yosakura.entity;

public class Hero {
	private Long id;
	private String name;
	private Integer hp;
	private Integer fighting;
	public Hero(Long id, String name, Integer hp, Integer fighting) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.fighting = fighting;
	}
	public Hero() {
		super();
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
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getFighting() {
		return fighting;
	}
	public void setFighting(Integer fighting) {
		this.fighting = fighting;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", hp=" + hp + ", fighting=" + fighting + "]";
	}
	
}

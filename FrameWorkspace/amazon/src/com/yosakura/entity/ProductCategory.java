package com.yosakura.entity;

public class ProductCategory {
	private Long id;
	private String name;
	private Long parentId;
	public ProductCategory() {
		super();
	}
	public ProductCategory(Long id, String name, Long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
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
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
	
	
}

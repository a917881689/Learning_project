package com.yosakura.entity;

import java.util.List;
/**
 * 分类模型
 */
public class PageListModel<T> {
	private T Product;
	private List<PageListModel<T>> son;
	public PageListModel() {
		super();
	}
	public PageListModel(T product, List<PageListModel<T>> son) {
		super();
		Product = product;
		this.son = son;
	}
	public T getProduct() {
		return Product;
	}
	public void setProduct(T product) {
		Product = product;
	}
	public List<PageListModel<T>> getSon() {
		return son;
	}
	public void setSon(List<PageListModel<T>> son) {
		this.son = son;
	}
	@Override
	public String toString() {
		return "PageListModel [Product=" + Product + ", son=" + son + "]";
	}
	
}

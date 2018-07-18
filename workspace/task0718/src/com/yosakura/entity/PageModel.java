package com.yosakura.entity;

import java.util.List;

/**
 * 通用分页模型
 *
 */
public class PageModel<T> {
	// 当前页
	private Integer currentPage;
	// 一页显示的个数
	private Integer pageSize;
	// 总记录数(count *)
	private Long total;
	// 总页数 (total/pageSize)
	private Integer totalPage;
	// 一页数据对象的集合
	private List<T> list;
	public PageModel() {
		super();
	}
	public PageModel(Integer currentPage, Integer pageSize, Long total, Integer totalPage, List<T> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
		this.list = list;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageModel [currentPage=" + currentPage + ", pageSize=" + pageSize + ", total=" + total + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
	
}

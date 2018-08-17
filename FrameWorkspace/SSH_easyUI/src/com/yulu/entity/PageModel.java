package com.yulu.entity;

import java.util.List;

public class PageModel<T> {
	// 当前页
	private Integer currentPage;
	// 一页显示的记录数
	private Integer pagesize;
	// 总记录数
	private Long totalCount;
	// 总页数
	private Integer totalPage;
	// 当前页对象集合
	private List<T> pageList;
	public PageModel() {
		super();
	}
	public PageModel(Integer currentPage, Integer pagesize, Long totalCount, Integer totalPage, List<T> pageList) {
		super();
		this.currentPage = currentPage;
		this.pagesize = pagesize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageList = pageList;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "PageModel [currentPage=" + currentPage + ", pagesize=" + pagesize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageList=" + pageList + "]";
	}
	
}

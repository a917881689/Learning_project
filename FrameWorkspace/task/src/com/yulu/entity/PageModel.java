package com.yulu.entity;

import java.util.List;
/**
 * 分页模型类
 */
public class PageModel<T> {
	private Integer currentPage; //当前页
	private Integer pageSize; //一页显示的记录数
	private Long totalCount; //总记录数
	private Integer totalPage; //总页数
	private List<T> pageList; //当前页对象集合
	public PageModel() {
		super();
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
		return "PageModel [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageList=" + pageList + "]";
	}
	
}

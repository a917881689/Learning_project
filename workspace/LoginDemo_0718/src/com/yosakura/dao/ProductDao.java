package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.entity.Product;



public interface ProductDao {
	/**
	 * 1.查询商品的总个数
	 * @return long类型的总条数
	 */
	long ProductCount () throws SQLException;
	/**
	 * 查询一页商品的数据
	 * @param currentPage 当前页
	 * @param pageSize 一页商品的个数
	 * @return 当前商品的集合
	 */
	List<Product> onePageProductList(int currentPage,int pageSize) throws SQLException;
}

package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.yosakura.entity.Product;



public interface ProductDao {
	/**
	 * 查询商品的总个数接口
	 * @return long类型的总条数
	 */
	long ProductCount () throws SQLException;
	/**
	 * 条件查询商品的总个数接口
	 * @param info 条件
	 * @return long类型的总条数
	 */
	long ProductCount(String info) throws SQLException;
	/**
	 * 查询一页商品的数据接口
	 * @param currentPage 当前页
	 * @param pageSize 一页商品的个数
	 * @return 当前商品的集合
	 */
	List<Product> onePageProductList(int currentPage,int pageSize) throws SQLException;
	/**
	 * 条件查询一页商品的数据接口
	 * @param info 条件
	 * @param currentPage 当前页
	 * @param pageSize 一页商品的个数
	 * @return 当前商品的集合
	 */
	List<Product> onePageProductList(String info, int currentPage, int pageSize) throws SQLException;
	
	/**
	 * 根据ID数组查询商品接口
	 * @param termsArray 商品id数组
	 * @return 查询的商品的集合
	 * @throws SQLException
	 */
	List<Product> queryProductsByidArray(Object[] termsArray) throws SQLException;
	/**
	 * 根据ID单个查询商品接口
	 * @param qr 查询对象
	 * @param terms 商品id
	 * @return 商品对象
	 * @throws SQLException
	 */
	Product queryProductById(QueryRunner qr, Object terms) throws SQLException;
	/**
	 * 根据ID单个查询商品接口
	 * @param terms 商品id
	 * @return 商品对象
	 * @throws SQLException
	 */
	Product queryProductById(Object terms) throws SQLException;
	
}

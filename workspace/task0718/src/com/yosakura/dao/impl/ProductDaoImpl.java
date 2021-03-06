package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yosakura.dao.ProductDao;
import com.yosakura.entity.Product;
import com.yosakura.util.C3P0Util;
/**
 * 商品持久层实现类
 * @author Administrator
 *
 */
public class ProductDaoImpl implements ProductDao{
	// 查询商品的总条数
	@Override
	public long ProductCount() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT COUNT(*) FROM product";
		return qr.query(sql, new ScalarHandler<>());
	}
	// 条件查询商品的总条数
	@Override
	public long ProductCount(String info) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT COUNT(*) FROM product WHERE brand like ? OR memo like ?";
		return qr.query(sql, new ScalarHandler<>(),info,info);
	}
	// 获取当前页商品的集合
	@Override
	public List<Product> onePageProductList(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,brand,memo,price,img FROM product limit ?,?";
		int start = (currentPage-1)*pageSize;
		return qr.query(sql,new BeanListHandler<Product>(Product.class),start,pageSize);
	}
	// 获取条件查询当前页商品的集合
	@Override
	public List<Product> onePageProductList(String info,int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,brand,memo,price,img FROM product WHERE brand like ? OR memo like ? limit ?,?";
		int start = (currentPage-1)*pageSize;
		return qr.query(sql,new BeanListHandler<Product>(Product.class),info,info,start,pageSize);
	}
	// 根据ID数组查询商品
	@Override
	public List<Product> queryProductsByidArray(Object[] termsArray) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		List<Product>  list = new ArrayList<>();
		for (Object terms : termsArray) {
			Product product = queryProductById(qr,terms);
			if (product != null) {
				list.add(product);
			}
		}
		return list;
	}
	@Override
	public Product queryProductById(QueryRunner qr,Object terms) throws SQLException {
		String sql = "SELECT id,brand,memo,price,img FROM product WHERE id = ?";
		return qr.query(sql,new BeanHandler<Product>(Product.class),terms);
	}
	@Override
	public Product queryProductById(Object terms) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		return queryProductById(qr,terms);
	}
}

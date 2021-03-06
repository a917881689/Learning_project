package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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
	// 1.查询商品的总条数
		@Override
		public long ProductCount() throws SQLException {
			QueryRunner qr = C3P0Util.getQueryRunner();
			String sql = "SELECT COUNT(*) FROM product";
			return qr.query(sql, new ScalarHandler<>());
		}
		// 获取当前页商品的集合
		@Override
		public List<Product> onePageProductList(int currentPage, int pageSize) throws SQLException {
			QueryRunner qr = C3P0Util.getQueryRunner();
			String sql = "SELECT id,brand,memo,price,img FROM product limit ?,?";
			int start = (currentPage-1)*pageSize;
			return qr.query(sql,new BeanListHandler<Product>(Product.class),start,pageSize);
		}
}

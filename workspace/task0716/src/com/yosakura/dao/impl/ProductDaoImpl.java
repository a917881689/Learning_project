package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yosakura.dao.ProductDao;
import com.yosakura.entity.Product;
import com.yosakura.util.C3P0Util;

public class ProductDaoImpl implements ProductDao{
	@Override
	public List<Product> getProducts () throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from product";
		List<Product> list = qr.query(sql,new BeanListHandler<Product>(Product.class));
		return list != null && list.size() > 0?list:null;
	} 
}

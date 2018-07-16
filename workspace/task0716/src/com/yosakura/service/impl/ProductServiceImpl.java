package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.dao.impl.ProductDaoImpl;
import com.yosakura.entity.Product;
import com.yosakura.service.ProductService;

public class ProductServiceImpl implements ProductService{
	@Override
	public List<Product> getProducts () {
		List<Product> list = null;
		try {
			new ProductDaoImpl().getProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

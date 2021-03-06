package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.dao.impl.ProductDaoImpl;
import com.yosakura.entity.PageModel;
import com.yosakura.entity.Product;
import com.yosakura.service.ProductService;

public class ProductServiceImpl implements ProductService{
	/**
	 * 分页查询商品
	 */
	@Override
	public PageModel<Product> pageProduct(int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			// 1.获取商品的总个数
			long total = pdi.ProductCount();
			// 2.计算总页数
			int totalPage = (int)(total%pageSize == 0?total/pageSize:total/pageSize+1);
			// 3.获取当前页所有商品的集合
			List<Product> list = pdi.onePageProductList(currentPage, pageSize);
			// 4.将以上分页参数封装到PageModel对象中
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageModel;
	}
	/**
	 * 根据ID数组查询商品
	 */
	@Override
	public List<Product> queryProductsByidArray(Object[] termsArray) {
		List<Product>  list = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			list = pdi.queryProductsByidArray(termsArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public PageModel<Product> queryProduct(String info,int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			// 1.获取条件查询商品的总个数
			long total = pdi.ProductCount("%"+info+"%");
			// 2.计算总页数
			int totalPage = (int)(total%pageSize == 0?total/pageSize:total/pageSize+1);
			// 3.获取当前页所有商品的集合
			List<Product> list = pdi.onePageProductList("%"+info+"%",currentPage, pageSize);
			// 4.将以上分页参数封装到PageModel对象中
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageModel;
	}
	
	@Override
	public Product queryProductById(Object terms) {
		Product  pro = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			pro = pdi.queryProductById(terms);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
}

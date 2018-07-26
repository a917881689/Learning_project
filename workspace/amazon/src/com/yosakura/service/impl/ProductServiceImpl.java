package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yosakura.dao.impl.ProductDaoImpl;
import com.yosakura.entity.PageListModel;
import com.yosakura.entity.PageModel;
import com.yosakura.entity.Product;
import com.yosakura.entity.ProductCategory;
import com.yosakura.service.ProductService;

public class ProductServiceImpl implements ProductService{
	public static void main(String[] args) {
//		List<PageListModel<ProductCategory>> queryProductClassify = new ProductServiceImpl().queryProductClassify();
//		for (PageListModel<ProductCategory> pageListModelA : queryProductClassify) {
//			System.out.println("A"+pageListModelA.getProduct().getName());
//			for (PageListModel<ProductCategory> pageListModelB : pageListModelA.getSon()) {
//				System.out.println("B"+pageListModelB.getProduct().getName());
//				for (PageListModel<ProductCategory> pageListModelC : pageListModelB.getSon()) {
//					System.out.println("C"+pageListModelC.getProduct().getName());
//				}
//			}
//		}
	}
	/**
	 * 查询前五的畅销商品
	 */
	@Override
	public List<Product> querypopularProduct() {
		List<Product> list = null;
		ProductDaoImpl pdi = new ProductDaoImpl();
		try {
			list = pdi.querypopularProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 随机查询十二条数据,用作首页显示
	 */
	@Override
	public List<Product> queryMajorProduct() {
		List<Product> list = null;
		ProductDaoImpl pdi = new ProductDaoImpl();
		try {
			list = pdi.queryMajorProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 分页查询商品
	 */
	@Override
	public PageModel<Product> queryProduct(int currentPage, int pageSize) {
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
	 * 查询商品所有分类
	 */
	@Override
	public List<PageListModel<ProductCategory>> queryProductClassify() {

		ProductDaoImpl pdi = new ProductDaoImpl();
		List<PageListModel<ProductCategory>> listProModelA = new ArrayList<>();
		try {
			//获取一级分类
			List<ProductCategory> ClassA = pdi.queryProClassify();
		
			for (ProductCategory proClass : ClassA) {
				List<PageListModel<ProductCategory>> listProModelB = new ArrayList<>();
				
				//获取二级分类
				List<ProductCategory> ClassB = pdi.queryProClassify(proClass.getId());
				for (ProductCategory proclassTwo : ClassB) {

					// 获取三级分类
					List<ProductCategory> ClassC = pdi.queryProClassify(proclassTwo.getId());
					List<PageListModel<ProductCategory>> listProModelC = new ArrayList<>();	

					for (ProductCategory proCategory : ClassC) {
						// 封装三级分类
						listProModelC.add(new PageListModel<ProductCategory>(proCategory,null));
					}
					// 封装二级分类
					listProModelB.add(new PageListModel<ProductCategory>(proclassTwo,listProModelC));
				}
				// 封装一级分类
				listProModelA.add(new PageListModel<ProductCategory>(proClass,listProModelB));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProModelA;
	}
	@Override
	public List<Product> queryProductsByidArray(Object[] termsArray,int number) {
		if (termsArray.length <= number) {
			return queryProductsByidArray(termsArray);
		}
		Object[] objArr = new Object[number];
		for (int i = 0; i < number;i++) {
			objArr[i] = termsArray[i];
		}
		return queryProductsByidArray(objArr);
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
	/**
	 * 根据条件分页查询商品分类
	 */
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
	/**
	 * 根据类别id分页查询商品
	 */
	@Override
	public PageModel<Product> queryProduct(long cid,int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			// 1.获取类别id查询商品的总个数
			long total = pdi.ProductCount(cid);
			// 2.计算总页数
			int totalPage = (int)(total%pageSize == 0?total/pageSize:total/pageSize+1);
			// 3.获取当前页所有商品的集合
			List<Product> list = pdi.onePageProductList(cid,currentPage, pageSize);
			// 4.将以上分页参数封装到PageModel对象中
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageModel;
	}
	
	@Override
	public PageModel<Product> queryProduct(long cid, String info, int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		try {
			ProductDaoImpl pdi = new ProductDaoImpl();
			// 1.获取类别id查询商品的总个数
			long total = pdi.ProductCount(cid,info);
			// 2.计算总页数
			int totalPage = (int)(total%pageSize == 0?total/pageSize:total/pageSize+1);
			// 3.获取当前页所有商品的集合
			List<Product> list = pdi.onePageProductList(cid,info,currentPage, pageSize);
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
	@Override
	public PageModel<Product> getProduct(String cid, String info, int currentPage, int pageSize) {
		PageModel<Product> pageModel = null;
		// 分页查询商品,判断条件是否为空
		if (info == null || "".equals(info)) {
			if (cid == null || "".equals(cid)) {
				// 条件(info)、类别id都为空
				pageModel = queryProduct(currentPage, pageSize);
				System.out.println("条件(info)、类别id都为空");
			}else {
				// 条件(info)为空,类别id不为空
				pageModel = queryProduct(Long.parseLong(cid),currentPage, pageSize);
				System.out.println("条件(info)为空,类别id不为空");
			}
		}else{
			if (cid == null || "".equals(cid)) {
				// 条件(info)不为空,类别id空
				pageModel = queryProduct(info,currentPage, pageSize);
				System.out.println("条件(info)不为空,类别id空");
			}else {
				// 条件(info),类别id都不为空
				pageModel = queryProduct(Long.parseLong(cid),info,currentPage, pageSize);
				System.out.println("条件(info),类别id都不为空");
			}
		}
		return pageModel;
	}
	
}

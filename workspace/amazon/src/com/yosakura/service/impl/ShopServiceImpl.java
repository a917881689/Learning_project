package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yosakura.dao.impl.ProductDaoImpl;
import com.yosakura.dao.impl.ShopDaoImpl;
import com.yosakura.entity.Product;
import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;
import com.yosakura.service.ShopService;

public class ShopServiceImpl implements ShopService{
	public static void main(String[] args) {
	}
	//添加商品到购物车
	@Override
	public int addShopCart(Shop shop) {
		int result = 0;
		try {
			ShopDaoImpl sdi = new ShopDaoImpl();
			// 查找有没有相同的商品在购物车
			Long id = sdi.queryShopCart(shop);
			if (id != null){
				// 有相同商品,进行梳理修改
				result = sdi.updateShopCart(id,shop.getPnum());	
			}else {
				// 没有相同商品,进行增加
				result = sdi.addShopCart(shop);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 把cookie购物车数据添加到数据库中
	 * @param uid
	 * @param cookieJson
	 * @return
	 */
	@Override
	public int addShopCart(long uid,String cookieJson) {
		int result = 0;
		List<ShopCartModel> queryShopCart = this.queryShopCart(cookieJson);
		for (ShopCartModel scm : queryShopCart) {
			result += this.addShopCart(new Shop(scm.getPro().getId(),scm.getPnum(),uid));
		}
		return result;
	}
	
	/**
	 * 查询已登录用户的购物车数据，返回购物车商品集合
	 */
	@Override
	public List<ShopCartModel> queryShopCart(long uid) {
		// 查询用户的购物车数据
		List<ShopCartModel> shopCartList = null;
		try {
			// 获取
			List<Shop> list = new ShopDaoImpl().queryShopCart(uid);
			if (list != null && list.size() > 0) {
				shopCartList = new ArrayList<>();
				ProductDaoImpl pdi = new ProductDaoImpl();
				for (Shop shop : list) {
			    	// 根据商品id获取商品数据
					Product pro = pdi.queryProductById(shop.getPid());
					if (pro != null) {
						// 根据商品数据和商品数量新建购物车商品模型，添加到集合中 ||需要一个购物车id用作购买成功时，来清空购物车
						shopCartList.add(new ShopCartModel(pro,shop.getPnum(),shop.getId()));
					}
			    }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopCartList;
	}
	/**
	 * 根据cookie购物车数据返回购物车商品集合
	 */
	@Override
	public List<ShopCartModel> queryShopCart(String cookieJson) {
		List<ShopCartModel> shopCartList = new ArrayList<>();
		List<Shop> list = JSON.parseArray(cookieJson, Shop.class);
	    ProductDaoImpl pdi = new ProductDaoImpl();
	    System.out.println("list:"+list);
	    try {
		    for (Shop shop : list) {
		    	// 根据商品id获取商品数据
				Product pro = pdi.queryProductById(shop.getPid());
				System.out.println(shop.getPid());
				if (pro != null) {
					// 根据商品数据和商品数量新建购物车商品模型，添加到集合中
					shopCartList.add(new ShopCartModel(pro,shop.getPnum()));
				}
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return shopCartList;
	}
}

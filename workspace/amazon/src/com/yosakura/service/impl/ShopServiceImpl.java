package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yosakura.dao.impl.ShopDaoImpl;
import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;
import com.yosakura.service.ShopService;

public class ShopServiceImpl implements ShopService{
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
				result = sdi.updateShopCart(new Shop(id,shop.getPnum()));	
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
	 * 查询已登录用户的购物车模型
	 */
	@Override
	public List<ShopCartModel> queryShopCart(long uid) {
		
	}
	/**
	 * 根据cookie购物车数据返回购物车模型
	 */
	@Override
	public List<ShopCartModel> queryShopCart(String cookieJson) {
		List<Shop> list = JSON.parseArray(cookieJson, Shop.class);
	    System.out.println(list);
	}
}

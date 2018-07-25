package com.yosakura.service;

import java.util.List;

import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;

public interface ShopService {
	/**
	 * 添加商品到购物车
	 * @param shop 待记录购物车对象
	 * @return 返回影响的行数
	 */
	int addShopCart(Shop shop);

	/**
	 * 根据用户id查询数据库，生成购物车数据
	 * @param uid
	 * @return 购物车商品集合
	 */
	List<ShopCartModel> queryShopCart(long uid);

	/**
	 * 根据cookie数据查询数据库，生成购物车数据
	 * @param cookieJson
	 * @return 购物车商品集合
	 */
	List<ShopCartModel> queryShopCart(String cookieJson);
	
	/**
	 * 将cookie数据添加到数据库中
	 * @param uid 用户id
	 * @param cookieJson cookie购物车json
	 * @return 购物车商品集合
	 */
	int addShopCart(long uid, String cookieJson);
}

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

	List<ShopCartModel> queryShopCart(long uid);
}

package com.yosakura.service.impl;

import java.sql.SQLException;

import com.yosakura.dao.impl.ShopDaoImpl;
import com.yosakura.entity.Shop;
import com.yosakura.service.ShopService;

public class ShopServiceImpl implements ShopService{
	//添加商品到购物车
	@Override
	public int addShopCart(Shop shop) {
		int result = 0;
		try {
			ShopDaoImpl sdi = new ShopDaoImpl();
			Long id = sdi.queryShopCart(shop);
			if (id != null){
				result = sdi.updateShopCart(new Shop(id,shop.getPnum()));	
			}else {
				result = sdi.addShopCart(shop);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

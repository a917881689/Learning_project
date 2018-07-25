package com.yosakura.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yosakura.dao.ShopDao;
import com.yosakura.entity.Shop;
import com.yosakura.util.C3P0Util;
import com.yosakura.util.SqlUtil;

public class ShopDaoImpl implements ShopDao {
	// 根据商品id和用户id查询购物车
	public Long queryShopCart(Shop shop) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT id,pid,pnum,uid FROM shop_cart WHERE pid=? AND uid=?";
		return qr.query(sql,new ScalarHandler<Long>(),shop.getPid(),shop.getUid());
		
	}
	// 添加商品到购物车
	@Override
	public int addShopCart(Shop shop) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		Object[] objAttr = SqlUtil.getObjAttr(shop);
		String sql = "INSERT INTO shop_cart(pid,pnum,uid) VALUES(?,?,?)";
		return qr.update(sql,objAttr);
	}
	public int updateShopCart(Shop shop) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "UPDATE shop_cart SET pnum=pnum+? WHERE id=?";
		return qr.update(sql,shop.getPnum(),shop.getId());
	}

}

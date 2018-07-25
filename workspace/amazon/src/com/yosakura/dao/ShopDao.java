package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.entity.Shop;

public interface ShopDao {
	/**
	 * 添加商品到购物车
	 * @param shop 待记录购物车对象
	 * @return 返回影响的行数
	 * @throws SQLException 
	 */
	int addShopCart(Shop shop) throws SQLException;

	/**
	 * 根据用户id和商品id查询购物车记录是否为空
	 * @param shop 购物车对象（包含用户id和商品id属性）
	 * @return 返回购物车查询的id(没有返回null)
	 * @throws SQLException
	 */
	Long queryShopCart(Shop shop) throws SQLException;
	/**
	 * 根据用户id查询购物车数据
	 * @param uid 用户id
	 * @return 返回购物车对象集合
	 * @throws SQLException
	 */
	List<Shop> queryShopCart(long uid) throws SQLException;
	/**
	 * 根据购物车对象的id和数量修改数据
	 * @param pid 购物车的id
	 * @param pnum 商品数量
	 * @return 受影响的行数
	 * @throws SQLException
	 */
	int updateShopCart(long pid, int pnum) throws SQLException;

	

	
}

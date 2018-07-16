package com.yosakura.dao;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.entity.GType;
import com.yosakura.entity.Goods;

public interface GoodsDao {

	List<GType> getGoodsType() throws SQLException;
	int addGoods(Goods Goods) throws SQLException;
	List<Goods> getGoods() throws SQLException;
	List<Goods> getGoods(String sql, Object[] objects) throws SQLException;
	int delGoods(long goodsId) throws SQLException;
	int updateGoods(Goods goods) throws SQLException;
}

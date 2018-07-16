package com.yosakura.service;

import java.util.List;

import com.yosakura.entity.GType;
import com.yosakura.entity.Goods;

public interface GoodsService {

	List<GType> getGoodsType();
	int addGoods(Goods goods);
	List<Goods> getGoods();
	int delGoods(long goodsId);
	int updateGoods(Goods goods);
	List<Goods> getGoods(Goods goods);
	List<Goods> getGoods(int page);
}
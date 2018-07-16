package com.yosakura.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.yosakura.dao.impl.GoodsDaoImpl;
import com.yosakura.entity.GType;
import com.yosakura.entity.Goods;
import com.yosakura.service.GoodsService;
import com.yosakura.util.SqlUtil;

public class GoodsServiceImpl implements GoodsService{
	@Override
	public List<Goods> getGoods() {
		List<Goods> goods = null;
		try {
			goods = new GoodsDaoImpl().getGoods();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	// 页码查看
	@Override
	public List<Goods> getGoods(int page) {
		List<Goods> goods = null;
		try {
			goods = new GoodsDaoImpl().getGoods((page-1)*12,page*12);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	@Override
	public List<Goods> getGoods(Goods goods) {
		List<Goods> goodsList = null;
		Object[] objArray = SqlUtil.getObjAttr(goods);
		
		if (objArray == null || objArray.length == 0 ) {
			return getGoods();
		}
		String sql = null;
		if (objArray.length == 1 ) {
			if (goods.getgName() == null || "".equals(goods.getgName())) {
				sql = "SELECT gid,gname,typeId,price FROM t_goods WHERE typeId = ?";
			}else {
				sql = "SELECT gid,gname,typeId,price FROM t_goods WHERE gname LIKE ?";
				objArray[0] = "%"+objArray[0]+"%";
			}
		}
		if (objArray.length == 2 ) {
			sql = "SELECT gid,gname,typeId,price FROM t_goods WHERE gname LIKE ? AND  typeId = ?";
			objArray[0] = "%"+objArray[0]+"%";
		}
		try {
			goodsList = new GoodsDaoImpl().getGoods(sql,objArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Override
	public List<GType> getGoodsType() {
		List<GType> gtypes = null;
		try {
			gtypes = new GoodsDaoImpl().getGoodsType();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gtypes;
	}
	
	@Override
	public int delGoods(long goodsId) {
		int rows = 0;
		try {
			rows = new GoodsDaoImpl().delGoods(goodsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public int updateGoods(Goods goods) {
		int rows = 0;
		try {
			rows = new GoodsDaoImpl().updateGoods(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public int addGoods(Goods goods) {
		int rows = 0;
		try {
			rows = new GoodsDaoImpl().addGoods(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
}
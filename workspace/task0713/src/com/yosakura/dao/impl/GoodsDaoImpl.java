package com.yosakura.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yosakura.dao.GoodsDao;
import com.yosakura.entity.GType;
import com.yosakura.entity.Goods;
import com.yosakura.util.C3P0Util;
import com.yosakura.util.SqlUtil;

public class GoodsDaoImpl implements GoodsDao{
	public static void main(String[] args) {
		
	}
	@Override
	public List<Goods> getGoods() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT gid,gname,typeId,price FROM t_goods";
		List<Goods> list = qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		return list != null && list.size() > 0?list:null;
	}
	@Override
	public List<Goods> getGoods(String sql,Object[] objects) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		List<Goods> list = qr.query(sql,new BeanListHandler<Goods>(Goods.class),objects);
		return list != null && list.size() > 0?list:null;
	}
	@Override
	public List<GType> getGoodsType() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT tid,tname FROM t_gtype";
		List<GType> list = qr.query(sql,new BeanListHandler<GType>(GType.class));
		return list != null && list.size() > 0?list:null;
	}
	// 删除商品
	@Override
	public int delGoods(long goodsId) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "DELETE FROM t_goods WHERE gId = ?";
		return qr.update(sql,goodsId);
	}
	// 修改商品
	@Override
	public int updateGoods(Goods goods) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "UPDATE t_goods SET gname = ?,typeId = ?,price = ? WHERE gId = ?";
		Object[] objArray = SqlUtil.getObjAttr(goods);
		objArray = new Object[]{objArray[1],objArray[2],objArray[3],objArray[0]};
		return qr.update(sql,objArray);
	}
	// 添加商品
	@Override
	public int addGoods(Goods goods) throws SQLException{
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "INSERT INTO t_goods(gname,typeId,price) VALUES(?,?,?)";
		Object[] objArray = SqlUtil.getObjAttr(goods);
		return qr.update(sql,objArray);
	}
	public List<Goods> getGoods(int pageN, int pageX) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT gid,gname,typeId,price FROM t_goods limit ?,? ";
		List<Goods> list = qr.query(sql,new BeanListHandler<Goods>(Goods.class),pageN,pageX);
		return list != null && list.size() > 0?list:null;
	}
	
}
package com.yosakura.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yosakura.dao.impl.OrderDaoImpl;
import com.yosakura.dao.impl.ProductDaoImpl;
import com.yosakura.entity.Order;
import com.yosakura.entity.OrderDetail;
import com.yosakura.entity.OrderModel;
import com.yosakura.entity.Product;
import com.yosakura.service.OrderService;

public class OrderServiceImpl implements OrderService{
	// 获取用户订单数据
	@Override
	public List<OrderModel> queryOrder(long uid) {
		List<OrderModel> list = new ArrayList<>();
		// 查询user的订单表数据
		OrderDaoImpl odi = new OrderDaoImpl();
		ProductDaoImpl pdi = new ProductDaoImpl();
		try {
			List<Order> orderList = odi.queryOrder(uid);
			Product pro = null;
			OrderDetail od = null;
			long oid;
			String time;
			BigDecimal totalPrice;
			long pid;
			Integer pnum;
		    // 查询商品对象
			for (Order order : orderList) {
				oid = order.getId();
				time = order.getCreateTime();
				totalPrice = order.getMoney();
				// 根据订单id查询商品id,和商品数量
				od = odi.queryOrderDetailById(oid);
				if (od == null) {
					continue;
				}
				pid = od.getPid();
				pnum = od.getQuantity();
				pro = pdi.queryProductById(pid);
				list.add(new OrderModel(oid,time,totalPrice,pnum,pro));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}

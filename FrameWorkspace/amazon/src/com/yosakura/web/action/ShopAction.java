package com.yosakura.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.entity.Shop;
import com.yosakura.entity.ShopCartModel;
import com.yosakura.entity.User;
import com.yosakura.service.impl.ShopServiceImpl;
import com.yosakura.util.CookieUtil;

public class ShopAction extends ActionSupport implements SessionAware,ModelDriven<Shop>,ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String result = null;
	public String getResult() {
		return result;
	}
	private User user;
	private Shop shop = new Shop();
	@Override
	public Shop getModel() {
		return shop;
	}
	public String addShop () {
		Long pid = shop.getPid();
		Integer pnum = shop.getPnum();
		
		if (pid == null || pnum == null ) {
			result = ERROR;
			return SUCCESS;
		}
		if (user != null) {
			// 用户登录
			long uid = user.getId();
			// 创建购物车记录
			ShopServiceImpl ssi = new ShopServiceImpl();
			// 截取临时购物车数据，进行更新
			List<Shop> tempShopCart = ssi.updateShopCart(uid,CookieUtil.getCookieValue(request.getCookies(),"tempShopCart"));
			response.addCookie(CookieUtil.getTempCookie(tempShopCart));
			// 增加到购物车
			int rs = ssi.addShopCart(new Shop(pid,pnum,uid));
			result = rs>0?"suc":"fail";
			return SUCCESS;
		}
		// 用户未登录
		// 获取cookie中的购物车数据,增加到cookie购物车
		String cookieShopCartjson = CookieUtil.getCookieValue(request.getCookies(),"shopCart");
		String shopCartjson = CookieUtil.addCookieShopCart(pid,pnum,cookieShopCartjson);
		System.out.println("cookie购物车"+shopCartjson);
		Cookie cookie = new Cookie("shopCart",shopCartjson);
		cookie.setMaxAge(60*60*24*3650);//过期时间为3650天
		// Cookie cookie = new Cookie("shopCart",null);
		// cookie.setMaxAge(0); // 销毁
		response.addCookie(cookie);
		result = "suc";
		return SUCCESS;
	}
	public String delShop () {
		System.out.println(user);
		// 判断有没有登录
		if (user == null) {
			// 没有登录，获取商品id;
			Long pid = shop.getPid();
			// 非空验证
			if (pid == null ) {
				result = "error";
				return SUCCESS;
			}
			// 获取cookie购物车数据
			String cookieShopCart = CookieUtil.getCookieValue(request.getCookies(),"shopCart");
			Cookie cookie = CookieUtil.getCookie("shopCart", CookieUtil.delCookieShopCart(pid,cookieShopCart));
			response.addCookie(cookie);
			result = "sue";
			return SUCCESS;
		}
		// 用户已登录，获取购物车记录id
		Long sid = shop.getId();
		long uid = user.getId();
		// 非空验证
		if (sid == null ) {
			result = "error";
			return SUCCESS;
		}
		// 删除cookie购物车记录
		String tempShopCart = CookieUtil.getCookieValue(request.getCookies(),"tempShopCart");
		tempShopCart = CookieUtil.delCookieTempShopCart(uid, sid, tempShopCart);
		Cookie cookie = CookieUtil.getCookie("tempShopCart", "tempShopCart");
		response.addCookie(cookie);
		// 调用业务层删除记录
		int rs = new ShopServiceImpl().delShopCart(uid,sid);
		result = rs==1?"sue":"error";
		return SUCCESS;
	}
	public String queryShopCart () {
		ShopServiceImpl ssi = new ShopServiceImpl();
		List<ShopCartModel> list = null;
		if (user != null) {
			// 用户登录
			long uid = user.getId();	
			Cookie[] cookies = request.getCookies();
			// getCookieValue()获取cookie临时购物车数据，updateShopCart()更新临时购物车数据
			 List<Shop> tempShopCart = ssi.updateShopCart(uid,CookieUtil.getCookieValue(cookies,"tempShopCart"));
			 response.addCookie(CookieUtil.getTempCookie(tempShopCart));
			// 获取cookie购物车数据,查看是否有数据
			String cookieShopCartjson = CookieUtil.getCookieValue(cookies,"shopCart");
			if (cookieShopCartjson != null && !"".equals(cookieShopCartjson)) {
				// 添加cookie购物车数据到购物车
				ssi.addShopCart(uid,cookieShopCartjson);
				Cookie cookie = new Cookie("shopCart",null);
				cookie.setMaxAge(0); //销毁
				// 处理剩下的cookie购物车数据
				response.addCookie(cookie);
			}
			list = ssi.queryShopCart(uid);		
		}else {
			// 用户未登录
			// 查询购物车模型
			String cookieShopCartjson = CookieUtil.getCookieValue(request.getCookies(),"shopCart");
			System.out.println("cookie数据"+cookieShopCartjson);
			if (cookieShopCartjson != null && !"".equals(cookieShopCartjson)) {
				list = ssi.queryShopCart(cookieShopCartjson);
			}	
		}
		String shopCartJSON = JSON.toJSONString(list);
		System.out.println("购物车数据"+shopCartJSON);
		// 处理空的购物车
		result = shopCartJSON;
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
	        this.session = session;
	        this.user = (User)session.get("loginUser");
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}

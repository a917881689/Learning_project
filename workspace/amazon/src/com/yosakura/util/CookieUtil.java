package com.yosakura.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yosakura.entity.Shop;

public class CookieUtil {
	public static String getCookieValue(Cookie[] cookies, String old_pid) {
		if (cookies == null || old_pid == null) {
			return null;
		}
		String pid = null;
		// 遍历cookie数组
		for (Cookie cookie : cookies) {
			// 找到old_pid 相同的cookie Name;
			if (old_pid.equals(cookie.getName())) {
				pid = cookie.getValue();
			}
		}
		return pid;
	}
	// 对一个数组和元素去重,重新排序 新元素放在最前面
	public static String[] distict (String[] old,String news) {
		LinkedList<String> oldList = new LinkedList<>();
		boolean flag = true;
		for (String str : old) {
			if (!"".equals(str) && !"null".equals(str)) {
				if (flag && str.equals(news)) {
					oldList.addFirst(news);	
					flag = false;
				}else {
					oldList.addLast(str);
				}
			}
			
		}
		if (flag) {
			oldList.addFirst(news);	
		}
		String[] strs = new String[oldList.size()];
		int i = 0;
		for (String str : oldList) {
			strs[i] = str;
			i++;
		}
		return strs;
	}
	// 拼接字符串
	public static String getString(String[] pids) {
		if (pids == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (pids != null) {
			for (String pid : pids) {
				sb.append(pid).append(",");
			}
		}
		return sb.substring(0,sb.length()-1);
	}
	// cookie购物车
	public static String addCookieShopCart(long pid, int pnum, String cookieShopCartjson) {
		// 判断cookie中是否有数据
		if (cookieShopCartjson == null || "".equals(cookieShopCartjson)) {
			// 没有数据直接创建一个购物车集合，添加到cookie中
			List<Shop> shopCartList = new ArrayList<>();
			shopCartList.add(new Shop(pid,pnum));
			return JSON.toJSONString(shopCartList);
		}
		// 有数据获取json，转换成购物车集合，
		JSONArray jsonArray = JSON.parseArray(cookieShopCartjson);
		boolean flag = true;
		// 判断是否有重复数据
		JSONObject jsonObj = null;
		 for (int i=0;i<jsonArray.size();i++) {
			 jsonObj = jsonArray.getJSONObject(i);
			 if (Long.parseLong(jsonObj.get("pid").toString()) == pid) {
					// 有重复数据,修改数量
				 jsonObj.put("pnum",Integer.parseInt(jsonObj.get("pnum").toString())+pnum);
				 flag = false;
				 break;
			 }
		 }
		 if (flag) {
			 jsonArray.add(JSONObject.parseObject(JSONObject.toJSONString(new Shop(pid,pnum))));
			// 没有重复数据，追加到json中
		 }
		// 返回修改好的购物车对象集合的json
		return jsonArray.toString();
	}
	// cookie购物车数量修改
	public static String updateCookieShopCart(Shop shop, String cookieShopCart) {
		// 非空验证
		if (cookieShopCart == null || "".equals(cookieShopCart)) {
			return null;
		}
		JSONArray jsonArray = JSON.parseArray(cookieShopCart);
		JSONObject jsonObj = null;
		for (int i=0;i<jsonArray.size();i++) {
			jsonObj = jsonArray.getJSONObject(i);
			if (Long.parseLong(jsonObj.get("pid").toString()) == shop.getPid()) {
				// 判断购物车商品id一致，进行数量修改
				jsonObj.put("pnum",shop.getPnum());
				break;
			}
		}		
		return jsonArray.toString();
	}
	// cookie临时购物车数量修改
	public static String updateCookieTempShopCart(Shop shop,String tempShopCart){
		// 没有就进行添加
		if (tempShopCart == null || "".equals(tempShopCart)) {
			List<Shop> shopCartList = new ArrayList<>();
			shopCartList.add(shop);
			return JSON.toJSONString(shopCartList);
		}
		// 有数据获取json，转换成购物车集合，
		JSONArray jsonArray = JSON.parseArray(tempShopCart);
		JSONObject jsonObj = null;
		for (int i=0;i<jsonArray.size();i++) {
			jsonObj = jsonArray.getJSONObject(i);
			if (Long.parseLong(jsonObj.get("id").toString()) == shop.getId() && Long.parseLong(jsonObj.get("uid").toString()) == shop.getUid()) {
				// 判断购物车id一致，并且用户id一致，进行数量修改
				jsonObj.put("pnum",shop.getPnum());
				break;
			}
		}		
		return jsonArray.toString();
	}
	// 将临时购物车集合转换成cookie
	public static Cookie  getTempCookie (List<Shop> tempList) {
		if (tempList == null || tempList.size() <= 0) {
			Cookie cookie = new Cookie("tempShopCart",null);
			cookie.setMaxAge(0);
			return cookie;
		}
		String jsonString = JSON.toJSONString(tempList);
		Cookie cookie = new Cookie("tempShopCart",jsonString);
		cookie.setMaxAge(60*60*24*3650);
		return cookie;
	}
	// 删除cookie购物车的数据,返回删除后的数据数据
	public static String delCookieShopCart(long pid,String cookieShopCart) {
		// 非空验证
		if (cookieShopCart == null || "".equals(cookieShopCart)) {
			return null;
		}
		JSONArray jsonArray = JSON.parseArray(cookieShopCart);
		JSONObject jsonObj = null;
		for (int i=0;i<jsonArray.size();i++) {
			jsonObj = jsonArray.getJSONObject(i);
			if (Long.parseLong(jsonObj.get("pid").toString()) == pid) {
				// 判断购物车商品id一致，进行删除
				System.out.println("删除数据："+jsonArray.remove(i).toString());
				break;
			}
		}		
		return jsonArray.toString();
	}
	// 删除临时购物车的数据,返回删除后的数据数据
	public static String delCookieTempShopCart(long uid,long sid,String tempShopCart) {
		// 非空验证
		if (tempShopCart == null || "".equals(tempShopCart)) {
			return null;
		}
		JSONArray jsonArray = JSON.parseArray(tempShopCart);
		JSONObject jsonObj = null;
		for (int i=0;i<jsonArray.size();i++) {
			jsonObj = jsonArray.getJSONObject(i);
			if (Long.parseLong(jsonObj.get("id").toString()) == sid && Long.parseLong(jsonObj.get("uid").toString()) == uid ) {
				// 判断购物车id一致，并且用户id一致，进行删除
				System.out.println("删除数据："+jsonArray.remove(i).toString());
				break;
			}
		}		
		return jsonArray.toString();
	}
	// 输入cookie名字和cookie值，返回一个cookie
	public static Cookie  getCookie (String cookieName,String cookieVal) {
		if (cookieVal == null || "".equals(cookieVal)) {
			Cookie cookie = new Cookie(cookieName,null);
			cookie.setMaxAge(0);
			return cookie;
		}
		Cookie cookie = new Cookie(cookieName,cookieVal);
		cookie.setMaxAge(60*60*24*3650);
		return cookie;
	}
}

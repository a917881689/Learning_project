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
	public static String updateCookieShopCart(Long pid, Integer pnum, String cookieShopCartjson) {
		String shopCartjson = null;
		// 判断cookie中是否有数据
		if (cookieShopCartjson == null || "".equals(cookieShopCartjson)) {
			// 没有数据直接创建一个购物车集合，添加到cookie中
			List<Shop> shopCartList = new ArrayList<>();
			shopCartList.add(new Shop(pid,pnum));
			shopCartjson = JSON.toJSONString(shopCartList);
		}else{
			// 有数据获取json，转换成购物车集合，
			JSONArray jsonArray = JSON.parseArray(cookieShopCartjson);
			boolean flag = true;
			// 判断是否有重复数据
			 for (int i=0;i<jsonArray.size();i++) {
				 JSONObject jsonObj = jsonArray.getJSONObject(i);
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
			 shopCartjson = jsonArray.toString();
		}
		// 返回修改好的购物车对象集合的json
		return shopCartjson;
	}
}

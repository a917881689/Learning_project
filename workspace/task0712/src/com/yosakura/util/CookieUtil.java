package com.yosakura.util;

import java.util.LinkedList;

import javax.servlet.http.Cookie;

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
		// LinkedHashSet<String> set = new LinkedHashSet<>();
		// TreeSet<String> set = new TreeSet<>();
		LinkedList<String> oldList = new LinkedList<>();
		boolean flag = true;
		for (String str : old) {
			if (flag && str.split("-")[0].equals(news.split("-")[0])) {
				oldList.addFirst(news);	
				flag = false;
			}else {
				oldList.addLast(str);
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
}

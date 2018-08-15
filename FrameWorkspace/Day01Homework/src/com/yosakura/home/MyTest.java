package com.yosakura.home;

public class MyTest {
	/* 1.问:Struts2中的action是不是单例的？为什么？多线程访问是否安全？
	 * 答：struts2的action是多例的，每次请求都会创建新的action对象与它的代理对象,线程安全的
	 * 
	 * 2.Servlet是不是单例的，为什么？多线程访问是否安全？
	 * 答：servlet是单例多线程的,因为默认访问时被创建一次,仅且只会执行一次init方法,因此它是单例的，
	 *  	因此在多线程并发访问的环境下servlet就会出现安全隐患
	 * 
	 * */
}

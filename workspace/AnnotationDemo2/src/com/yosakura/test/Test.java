package com.yosakura.test;

import java.lang.reflect.Method;

import com.yosakura.annotation.MyTest;

public class Test {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("com.yosakura.test.AnnotationTest");
		Object obj = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			method.setAccessible(true);
			if (method.isAnnotationPresent(MyTest.class))  {
				method.invoke(obj);
			}
			method.setAccessible(false);
		}
	}
	public static void dg () throws Exception {
		// 实现让带有@MyTest注解的方法执行
		Class<?> clazz = Class.forName("com.yosakura.annotation.MyTest");
		Class<?> objc = Class.forName("com.yosakura.test.AnnotationTest");
		Object obj = objc.newInstance();
		Method[] methods = objc.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(MyTest.class) != null)  {
				method.invoke(obj);
			}
					
		}
	}
}

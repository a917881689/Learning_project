package com.yosakura.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.yosakura.entity.User;

public class MethodTest {
	public static void main(String[] args) throws Exception {
		// 1.获取字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		User user = (User)clazz.newInstance();
		// 给字段赋值
		Field field = clazz.getDeclaredField("uname");
		field.setAccessible(true);
		field.set(user,"关羽");
		System.out.println(user);
		field.setAccessible(false);
		// 执行方法
		Method method = clazz.getDeclaredMethod("introduce");		
		// 执行方法获取返回值
		method.setAccessible(true);
		Object invoke = method.invoke(user);
		// 输出返回值
		System.out.println(invoke);
		method.setAccessible(false);
		
	}
	public static void getMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		// 1.获取字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 2.获取指定的方法
		Method method = clazz.getMethod("toString");
		// 获取方法的访问修饰符
		String modifier = Modifier.toString(method.getModifiers());
		// 获取返回值类型
		String returnType = method.getReturnType().getName();
		// 方法名
		String name = method.getName();
		// 形参类型的数组
		Class<?>[] parameterTypes = method.getParameterTypes();
		System.out.println(modifier+" "+returnType+" "+name+"(){}");
		User user = (User)clazz.newInstance();
		method.invoke(user);
	}
	// 获取类中所有的方法名
	public static void getAllmethod() throws ClassNotFoundException {
		// 1.获取字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 2.获取方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			method.setAccessible(true);
			System.out.println(method.getName());
		}
	}
}

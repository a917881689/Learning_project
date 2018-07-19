package com.yosakura.test;

import com.yosakura.entity.User;

public class UserTest {
	public static void main(String[] args) {
		// 1.创建一个User类型的对象
		User user = new User("张三","123");
		// 获取字节码的三种方式
		// 1>通过对象.getClass()获取class字节码对象，不使用
		Class<? extends User> clazz = user.getClass(); //class com.yosakura.entity.User
		// 2>通过类名.class可以获取到字节码对象 ?  extends User 决定?的上限是User
		Class<?  extends User> clazz2 = User.class;
		System.out.println(clazz2);
		// 3>通过Class.forName("完整的类路径")获取字节码对象（类的类对象）
		try {
			Class<?> clazz3 = Class.forName("com.yosakura.entity.User");
		} catch (ClassNotFoundException e) {
			System.out.println("Class字节码对象缺失");
			e.printStackTrace();
		}
	}
}

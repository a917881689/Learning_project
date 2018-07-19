package com.yosakura.entity;
// all压制类中所有的警告
@SuppressWarnings("all")
public class User extends Object {
	private String name;

	// 重写注解：会自动检测类中的方法是不是重写父类的方法（同名同参同返回值）
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	@SuppressWarnings("unused")
	public void test () {
		// @SuppressWarnings("unused")
		int a = 10;
	}
	
}

package com.yosakura.test;

import com.yosakura.annotation.MyAnnotation;
import com.yosakura.annotation.MyTest;

public class AnnotationTest {
	@MyAnnotation("chen")
	public void test () {
		System.out.println("我是使用了注解的方法");
	}
	@MyTest
	public void test1 () {
		System.out.println("我是test1");
	}
	@MyTest
	public void test2 () {
		System.out.println("我是test2");
	}
	@MyTest
	public void test3 () {
		System.out.println("我是test3");
	}
	@MyTest
	public void test4 () {
		System.out.println("我是test4");
	}
	@Deprecated //过时注解
	@MyTest
	public void test5 () {
		System.out.println("我是test5");
	}
}

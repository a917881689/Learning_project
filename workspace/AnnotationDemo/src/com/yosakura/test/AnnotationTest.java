package com.yosakura.test;

import com.yosakura.annotation.MyAnnotation;

public class AnnotationTest {
	@MyAnnotation("chen")
	public void test () {
		System.out.println("我是使用了注解的方法");
	}
}

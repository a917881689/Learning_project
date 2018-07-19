package com.yosakura.annotation;
/**
 * 自定义注解的语法
 * public @interface 注解名称 {
 * 	修饰符  类型  变量名();
 * 修饰符  类型  变量名() default 默认值;
 * }
 *	
 */
public @interface MyAnnotation {
	// 拥有默认值可以不用写
	public long id() default 0;
	public String name() default "";
	// 必要参数
	// 当只有一个value属性的时候,则使用的时候可以不用写value=
	public String value();
}

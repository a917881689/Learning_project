package com.yosakura.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解的语法
 * @Retention(ClASS SOURCE RUNTIME)
 * public @interface 注解名称 {
 * 	修饰符  类型  变量名();
 * 修饰符  类型  变量名() default 默认值;
 * }
 *	修饰注解的注解叫:元注解
 *	@Retention
 *	默认是SOURCE: 只有源码可见（编译后字节码没有注解，运行时更没有）
 *	ClASS：编译期可见(源码和编译后可见注解，但是在运行时注解没有)
 *	RUNTIME： 运行期(全部都可以找到)
 *	@Target 接收枚举数组
 *	TYPE:类可以用
 *	METHOD:方法上可用
 *	FIEDL:属性字段上可用
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {

}

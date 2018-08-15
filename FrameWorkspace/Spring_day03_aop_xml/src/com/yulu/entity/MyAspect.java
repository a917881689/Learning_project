package com.yulu.entity;

import org.aspectj.lang.ProceedingJoinPoint;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * 切面类 ：（通知：advice+切入点：pointCut）
 *
 */

public class MyAspect {
	
	// 1.前置通知
	public void before () {
		System.out.println("~~~~~~~~前置通知~~~~~~~~");
	}
	
	// 1.后置通知
	public void afterReturning (Object result) {
		System.out.println("~~~~~~~~后置通知~~~~~~~~");
		System.out.println(result);
	}
	
	// 1.环绕通知
	public void around (ProceedingJoinPoint point) throws Throwable {
		System.out.println("~~~~~~~~环绕前通知~~~~~~~~");
		long begin = System.currentTimeMillis();
		// 执行目标类的方法
		Object proceed = point.proceed();
		long end = System.currentTimeMillis();
		System.out.println("查询共执行"+(begin-end)+"毫秒");
		System.out.println("~~~~~~~~环绕后通知~~~~~~~~");
	}
	
	// 异常抛出通知
	public void exception(Throwable e) {
		System.out.println("异常正在处理中..."+e.getMessage());
	}
	// 最终通知,无论是否发送异常都会执行
	public void after () {
		System.out.println("最终通知");
	}
	public void serviceAdd (ProceedingJoinPoint point) throws Throwable {
		System.out.println("~~~~~~~~性能前测试~~~~~~~~");
		long begin = System.currentTimeMillis();
		// 执行目标类的方法
		Object proceed = point.proceed();
		long end = System.currentTimeMillis();
		System.out.println("查询共执行"+(begin-end)+"毫秒");
		System.out.println("~~~~~~~~性能后测试~~~~~~~~");
	}
}

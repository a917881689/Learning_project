package com.yulu.entity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类 ：（通知：advice+切入点：pointCut）
 *
 */
@Aspect  // @Aspect作用是把当前类标识为一个切面供容器读取
public class MyAspect2 {
	
	// 1.前置通知
	@Before("execution(* com.yulu.dao.impl.CustomerDaoImpl.add(..))")
	public void before () {
		System.out.println("~~~~~~~~前置通知~~~~~~~~");
	}
	
	// 1.后置通知
	@AfterReturning(value="execution(* com.yulu.dao.impl.CustomerDaoImpl.delete(..))",returning="result")
	public void afterReturning (Object result) {
		System.out.println("~~~~~~~~后置通知~~~~~~~~");
		System.out.println(result);
	}
	
	// 1.环绕通知
	@Around("execution(* com.yulu.dao.impl.CustomerDaoImpl.update(..))")
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
	@AfterThrowing(value="execution(* com.yulu.dao.impl.CustomerDaoImpl.query(..))",throwing="e")
	public void exception(Throwable e) {
		System.out.println("异常正在处理中..."+e.getMessage());
	}
	// 最终通知,无论是否发送异常都会执行
	@After("execution(* com.yulu.dao.impl.CustomerDaoImpl.query(..))")
	public void after () {
		System.out.println("最终通知");
	}
	

	
}

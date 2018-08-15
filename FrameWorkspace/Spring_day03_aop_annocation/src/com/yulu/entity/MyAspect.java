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
@Component
@Aspect  // @Aspect作用是把当前类标识为一个切面供容器读取
public class MyAspect {
	
	// 1.前置通知
	@Before("MyAspect.p1()")
	public void before () {
		System.out.println("~~~~~~~~前置通知~~~~~~~~");
	}
	
	// 1.后置通知
	@AfterReturning(value="MyAspect.p2()",returning="result")
	public void afterReturning (Object result) {
		System.out.println("~~~~~~~~后置通知~~~~~~~~");
		System.out.println(result);
	}
	
	// 1.环绕通知
	@Around("MyAspect.p3()")
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
	@AfterThrowing(value="MyAspect.p4()",throwing="e")
	public void exception(Throwable e) {
		System.out.println("异常正在处理中..."+e.getMessage());
	}
	// 最终通知,无论是否发送异常都会执行
	@After("MyAspect.p4()")
	public void after () {
		System.out.println("最终通知");
	}
	@Around("MyAspect.p5()")
	public void add (ProceedingJoinPoint point) throws Throwable {
		System.out.println("~~~~~[权限管理]~~~~~");
		// 执行被拦截的目标类的方法 （add方法）
		Object proceed = point.proceed();
		System.out.println("#####[权限校验]#####");
	}
	
	
	// 配置众多切点
	@Pointcut("execution(* com.yulu.dao.impl.CustomerDaoImpl.add(..))")
	public void p1 () {}
	@Pointcut("execution(* com.yulu.dao.impl.CustomerDaoImpl.delete(..))")
	public void p2 () {}
	@Pointcut("execution(* com.yulu.dao.impl.CustomerDaoImpl.update(..))")
	public void p3 () {}
	@Pointcut("execution(* com.yulu.dao.impl.CustomerDaoImpl.query(..))")
	public void p4 () {}
	@Pointcut("execution(* com.yulu.service.impl.*.add(..))")
	public void p5 () {}
}

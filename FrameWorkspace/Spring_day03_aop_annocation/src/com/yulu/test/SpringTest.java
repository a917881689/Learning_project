package com.yulu.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.dao.CustomerDao;
import com.yulu.service.CustomerService;
import com.yulu.service.OrderService;
import com.yulu.service.UserService;
/**
 * Spring 整合Junit4 的单元测试时
 * Spring会自动扫描测试类的注解
 * （OCP开闭原则）：  （JDK接口代理,）
 * 		1、对源代码修改关闭
 * 		2、对扩展开放
 * AOP主要用来解决
 * 		1、增强原方法
 *		1、切面aspect(MVC,让某一层面上的所有方法都执行1)
 *		3、极大提高代码的重用性，实现快速开发，修改扩展方便
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
	@Resource(name="customerDao")
	private CustomerDao cdi;
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="orderService")
	private OrderService orderService;
	@Resource(name="customerService")
	private CustomerService customerService;
	@Test
	public void demo2() {
		// 实现service层中的所有类的add方法添加一个前置的权限管理及后置的校验功能（环绕）
		userService.add();
		orderService.add();
		customerService.add();
	}
	
	// @Test
	public void demo1() {
		// 前置通知
		cdi.add();
		// 后置通知
		cdi.delete();
		// 环绕通知（前后）
		cdi.update();
		// 异常通知，最终通知
		cdi.query();
	}
	
	/**
	 * 实现切面步骤
	 * 1、将目标类交给Spring管理
	 * 2、编写切面类(增强方法)，交给Spring管理
	 * 3、在XML配置切面（切入点、在切入点使用增强方法（织入））
	 * 4.execution表达式语法：
	 * 		返回值类型 包.类.方法(参数)
	 */
}

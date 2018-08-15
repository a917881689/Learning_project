package com.yulu.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	// ModelDriver使用
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	
	// 1.跳转添加联系人页面
	public String saveUI () {
		return "saveUI";
	}
	// 2.添加客户
	public String save () {
		// 调用业务逻辑层的添加方法(业务逻辑层实现类由Spring管理)
		// 需要从ServletContext中获取web整合的Spring工厂
		ServletContext sc = ServletActionContext.getServletContext();
		// 使用Spring-web整合的工具从ServletContext中获取Spring工厂
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);

		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.addCustomer(customer);
		
		//此处为什么要通过spring工厂获取对象，是因为action是struts2框架创建了，限制还没有交由spring管理
		return NONE;
	}
	// 查看客户列表
	public String find () {
		// 需要从ServletContext中获取web整合的Spring工厂
		ServletContext sc = ServletActionContext.getServletContext();
		// 使用Spring-web整合的工具从ServletContext中获取Spring工厂
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		List<Customer> list = customerService.findCustomer();
		// 将查询到的数据放到request域中,（相当于放到值栈中的context中）
		ServletActionContext.getRequest().setAttribute("list",list);
		return "findUI";
	}
}

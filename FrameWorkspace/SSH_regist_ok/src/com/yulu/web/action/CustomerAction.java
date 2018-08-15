package com.yulu.web.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Override
	public Customer getModel() {
		return customer;
	}
	// 保存客户
	public String save () {
		System.out.println("执行保存save()方法");
		customerService.addCustomer(customer);
		return NONE;
	}
}

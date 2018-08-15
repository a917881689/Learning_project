package com.yulu.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;
@Namespace("/")
@ParentPackage("struts-default")
@Scope("prototype")
@Controller("customerAction")
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
	@Action(value="customer_save",results={@Result(name="success",location="/login.jsp"),
											@Result(name="error",location="/jsp/error.jsp")})
	public String save () {
		System.out.println("执行保存save()方法");
		customerService.addCustomer(customer);
		return SUCCESS;
	}
}

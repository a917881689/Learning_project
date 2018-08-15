package com.yulu.web.action;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	// ModelDriver使用
	private Customer customer = new Customer();
	private String result;
	
	public String getResult() {
		return result;
	}
	@Override
	public Customer getModel() {
		return customer;
	}
	// 注解注入业务层实现类对象，由XML管理注入对象
	@Resource(name="customerService")
	private CustomerService csi;
	
	// 1.添加客户
	public String save () {
		csi.addCustomer(customer);
		return NONE;
	}
	public String find() {
		System.out.println("customer开始find");
		List<Customer> list = csi.findCustomer();
		String jsonString = JSON.toJSONString(list,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		result = jsonString;
		return SUCCESS;
	}
}

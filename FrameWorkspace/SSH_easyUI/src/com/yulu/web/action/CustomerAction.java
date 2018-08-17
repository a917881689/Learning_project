package com.yulu.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;
import com.yulu.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	private CustomerService customerService;
	private Integer page = 1;
	private Integer rows = 3;

	@Override
	public Customer getModel() {
		return customer;
	}
	// 添加客户 (操作的数据都是异步的)
	public String save () throws IOException {
		HashMap<String,String> hashMap = new HashMap<>();
		try {
			customerService.addCustomer(customer);
			hashMap.put("msg","保存客户成功");
		} catch (Exception e) {
			hashMap.put("msg","保存客户失败");
			e.printStackTrace();
		}
		String jsonString = JSON.toJSONString(hashMap);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonString);
		return NONE;
	}
	// 分页查询所有客户的方法
	public String findAll() throws IOException {
		System.out.println("action");
		// 使用离线查询完成多条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		// 调用service层的查询方法
		PageModel<Customer> pageModel = customerService.findByPage(detachedCriteria,page,rows);
		// 返回datagrid需要的json格式的数据（规定好的接收total,rows）
		HashMap<String,Object> map = new HashMap<>();
		map.put("total",pageModel.getTotalCount());
		map.put("rows",pageModel.getPageList());
		String jsonString = JSON.toJSONString(map);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonString);
		System.out.println(jsonString);
		return NONE;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}

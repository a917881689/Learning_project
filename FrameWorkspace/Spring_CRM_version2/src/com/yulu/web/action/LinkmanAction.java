package com.yulu.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.entity.Linkman;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{
	private static final long serialVersionUID = 1L;
	private Linkman linkman = new Linkman();
	private Long cust_id;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	@Override
	public Linkman getModel() {
		return linkman;
	}
	
	public String add() {
		// 输出
		System.out.println("action获取："+linkman);
		// 设置联系人客户
		Customer customer = new Customer();
		customer.setCust_id(cust_id);
		linkman.setCustomer(customer);
		
		// SpringUtil.getLinkmanService().add(linkman);
		result = SUCCESS;
		return SUCCESS;
	}
}

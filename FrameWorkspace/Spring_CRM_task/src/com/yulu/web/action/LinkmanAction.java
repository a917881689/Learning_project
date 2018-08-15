package com.yulu.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.entity.Linkman;
import com.yulu.service.LinkmanService;
@Controller("linkmanAction")
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/")
public class LinkmanAction extends ActionSupport implements ServletRequestAware,ModelDriven<Linkman>{
	private static final long serialVersionUID = 1L;
	private Linkman linkman = new Linkman();
	private Long cust_id;
	private String result = NONE;
	private HttpServletRequest request;
	
	@Resource(name="linkmanService")
	private LinkmanService linkmanService;

	@org.apache.struts2.json.annotations.JSON
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
	public String find() {
		System.out.println("linkman开始find");
		List<Linkman> list = linkmanService.find();
		String jsonString = JSON.toJSONString(list,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		result = jsonString;
		return SUCCESS;
	}
	public String add() {
		// 输出
		System.out.println("linkman开始add："+linkman);
		// 设置联系人客户
		Customer customer = new Customer();
		customer.setCust_id(cust_id);
		linkman.setCustomer(customer);
		linkmanService.add(linkman);
		result = SUCCESS;
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;  
	}
	
	@Action(value="linkman_updateUI",results= {
			@Result(name="success",location="/jsp/linkman/edit.jsp"),
			@Result(name="error",location="/error.jsp")})
	public String updateUI () {
		Linkman resultLinkman = linkmanService.queryById(linkman.getLkm_id());
		request.setAttribute("linkman",resultLinkman);
		return SUCCESS;
	}

	@Action(value="linkman_update",results= {
			@Result(name ="success", type="json")})
	public String update() {
		System.out.println("LinkmanAction执行了save()方法");
		linkmanService.add(linkman);
		result = SUCCESS;
		return SUCCESS;
	}
}

package com.yulu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yulu.entity.Customer;
import com.yulu.entity.Linkman;
import com.yulu.service.LinkmanService;


@Controller
public class LinkmanController {
	@Autowired
	private LinkmanService linkmanService;


	@RequestMapping("/linkman-find")
	public @ResponseBody List<Linkman> find() {
		System.out.println("linkman开始find");
		List<Linkman> list = linkmanService.find();
		return list;
	}

	@RequestMapping("/linkman-add")
	public String add(@ModelAttribute Linkman linkman, @PathVariable long cust_id) {
		// 输出
		System.out.println("linkman开始add："+linkman);
		// 设置联系人客户
		Customer customer = new Customer();
		customer.setCust_id(cust_id);
		linkman.setCustomer(customer);
		linkmanService.add(linkman);
		return "success";
	}
	
	@RequestMapping("/linkman_updateUI")
	public ModelAndView updateUI ( long lkm_id) {
		Linkman resultLinkman = linkmanService.queryById(lkm_id);
		ModelAndView view = new ModelAndView();
		view.addObject("linkman",resultLinkman);
		view.setViewName("/jsp/linkman/edit.jsp");
		return view;
	}

	@RequestMapping("/linkman_update")
	public String update(@ModelAttribute Linkman linkman) {
		System.out.println("LinkmanAction执行了update()方法");
		linkmanService.update(linkman);
		return "success";
	}
}

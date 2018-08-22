package com.yulu.Springmvc.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//控制器层的注解
@Controller
public class ItemController {
	/**
	 * @RequestMapping 请求映射 （类似于Servlet中的url-prettrn）
	 * @ModelAndView 视图模型（视图名，数据） 
	 * @return
	 */
	@RequestMapping("/test")
	public ModelAndView testMVC() {
		System.out.println("hello SpringMVC");
		ModelAndView view = new ModelAndView();
		//返回的路径
		view.setViewName("/WEB-INF/test.jsp");
		// 存放页面需要的数据(底层调用的就是request.setAttr)
		view.addObject("uname","amdin");
		return view;
		
	}
	
	
}

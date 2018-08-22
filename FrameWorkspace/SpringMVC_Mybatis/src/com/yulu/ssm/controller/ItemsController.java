package com.yulu.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 控制器层
 *
 */
import org.springframework.web.servlet.ModelAndView;

import com.yulu.ssm.service.ItemsService;
@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/test")
	public ModelAndView testDemo() {
		System.out.println("开始执行Controller的test方法");
		// 调用业务逻辑接口
		itemsService.test();
		// 创建模型视图
		ModelAndView view = new ModelAndView();
		view.setViewName("success");
		return view;
	}
}

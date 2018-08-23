package com.yulu.controller.demo5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 统一管理父路径
@RequestMapping("/user/") 
public class TestRequestController {
	
	@RequestMapping(value="test", method=RequestMethod.POST)
	public void test() {
		System.out.println("test");
	}
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {
		System.out.println("add");
	}
	@RequestMapping("update")
	public void update() {
		System.out.println("update");
	}
}

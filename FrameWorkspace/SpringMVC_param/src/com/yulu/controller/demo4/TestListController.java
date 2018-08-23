package com.yulu.controller.demo4;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulu.controller.demo3.User;

@Controller
public class TestListController {
	
	@RequestMapping("testList")
	public void testList(Model model) {
		List<User> list = model.getList();
		System.out.println(list);
	}
}

package com.yulu.controller.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestObjController {
	/**
	 * 1.对象的参数封装
	 * 注意：表单input中的name属性要与实体类字段名一致
	 */
	@RequestMapping("/testobj1")
	public void testobj1(User user) {
		System.out.println(user);
	}
	
	/**
	 * 1.对象的参数封装
	 * 注意：表单input中的name属性要与实体类字段名一致
	 */
	@RequestMapping("/testobj2")
	public void testobj(UserPro user) {
		System.out.println(user.getUser());
	}
}

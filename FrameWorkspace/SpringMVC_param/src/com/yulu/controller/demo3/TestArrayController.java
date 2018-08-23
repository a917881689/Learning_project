package com.yulu.controller.demo3;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestArrayController {
	/**
	 * 1.对象的参数封装
	 * 注意：表单input中的name属性要与实体类字段名一致
	 */
	@RequestMapping("/testArray1")
	public void testArray1(String[] hobby) {
		System.out.println(Arrays.toString(hobby));
	}
	/**
	 * 1.对象的参数封装
	 * 注意：表单input中的name属性要与实体类字段名一致
	 */
	@RequestMapping("/testArray2")
	public void testArray2(User user) {
		System.out.println("user:"+user);
	}
	
}

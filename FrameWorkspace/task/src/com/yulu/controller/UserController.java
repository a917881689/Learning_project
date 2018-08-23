package com.yulu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yulu.entity.User;
import com.yulu.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/user_save")
	public String save(@ModelAttribute User user) {
		System.out.println("执行regist()方法");
		userService.add(user);
		return "success";
	}
	

	@RequestMapping("/user_delete")
	public String delete( Integer id) {
		System.out.println("执行regist()方法");
		userService.delete(id);
		return "success";
	}


    @RequestMapping("/user_update")
    public String update(@ModelAttribute User user) {
        System.out.println("执行regist()方法");
        userService.update(user);
        return "success";
    }

    @RequestMapping("/user_queryById")
    public @ResponseBody User queryById( Integer id) {
        System.out.println("执行regist()方法");
        User queryUser = userService.queryById(id);
        return queryUser;
    }
}

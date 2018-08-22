package com.yulu.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yulu.service.ItemsService;
import com.yulu.spring.pojo.Items;

@Controller
public class IetmsController {
	@Autowired
	private ItemsService itemsService;
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		List<Items> list = new ArrayList<>();
		list.add(new Items(1,"1华为 荣耀8",2399f,new Date(),"质量好！1"));
		list.add(new Items(2,"2锤子 创世8",2399f,new Date(),"质量好！2"));
		list.add(new Items(3,"3华为 荣耀9",2399f,new Date(),"质量好！3"));
		list.add(new Items(4,"4华为 荣耀10",2399f,new Date(),"质量好！4"));
		list.add(new Items(5,"5华为 荣耀10",2399f,new Date(),"质量好！5"));
		list.add(new Items(6,"6华为 荣耀10",2399f,new Date(),"质量好！6"));
		ModelAndView view = new ModelAndView();
		view.addObject("items",list);
		view.setViewName("itemList");
		return view;
		
	}
	
}

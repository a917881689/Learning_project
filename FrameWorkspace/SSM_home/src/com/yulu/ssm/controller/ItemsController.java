package com.yulu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 控制器层
 *
 */
import org.springframework.web.servlet.ModelAndView;

import com.yulu.ssm.pojo.Items;
import com.yulu.ssm.service.ItemsService;
@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/findAllItems.action")
	public ModelAndView findAllItems() {
		List<Items> list = itemsService.findAllItems();
		ModelAndView view = new ModelAndView();
		System.out.println(list);
		view.addObject("itemsList",list);
		view.setViewName("jsp/itemList");
		return view;
	}
	@RequestMapping("/itemDelete.action")
	public String itemDelete(Integer id) {
		itemsService.itemDelete(id);
		// 逻辑视图名
		return "success.jsp";
	}
	/**
	 * 跳转编辑回显数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/itemEdit.action")
	public String itemEdit(Integer id,ModelMap model) {
		Items items = itemsService.showEditUI(id);
		model.addAttribute("item",items);
		// 逻辑视图名
		return "jsp/editItem";
	}
	/**
	 * 编辑保存
	 * @param 
	 * @return
	 */
	@RequestMapping("/updateitem.action")
	public String updateitem(Items items) {
		itemsService.updateitem(items);
		// 重定向
		// response.sendRedirect("findAllItems.action");
		return "redirect:findAllItems.action";
	}
	
}

package com.yulu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 控制器层
 *
 */
import org.springframework.web.servlet.ModelAndView;

import com.yulu.ssm.pojo.Items;
import com.yulu.ssm.pojo.ItemsPro;
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
	
	@RequestMapping("/queryByName.action")
	public String queryByName(String name,ModelMap modelMap) {
		System.out.println(name);
		if (name != null && !"".equals(name)) {
			List<Items> list = itemsService.queryByName(name);
			modelMap.addAttribute("itemsList",list);
			return "jsp/itemList";
		}
		return "redirect:findAllItems.action";
	}
	
	@RequestMapping("/batchDelete.action")
	public String batchDelete(@RequestParam("idArray[]")Long[] idArray) {
		System.out.println(idArray);
		itemsService.batchDelete(idArray);
		return "success";
	}
	
	@RequestMapping("/batchUpdate.action")
	public String batchUpdate(ItemsPro itemsPro) {
		List<Items> list = itemsPro.getList();
		System.out.println(list);
		if (list != null && list.size() >0) {
			itemsService.batchUpdate(list);	
		}
		return "redirect:findAllItems.action";
	}
}

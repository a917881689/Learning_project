package com.yulu.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;
import com.yulu.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// 1.添加客户
	@RequestMapping("/customer_save")
	public String save (@ModelAttribute Customer customer) {
        int result = customerService.addCustomer(customer);
        return result>0?"success":"error";
	}

    @RequestMapping("/customer_delete")
    public String delete (long cust_id) {
        customerService.delete(cust_id);
        return "success";
    }
    
    @RequestMapping("/customer_update")
    public String update (@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "success";
    }

	/**
	 * 1.分页查询所有客户
	 * @throws IOException
	 */
    @RequestMapping("/customer_find")
	public @ResponseBody HashMap<String, Object> findAll(String cust_name, int page, int rows) throws IOException {
		//2.调用service层的查询方法
		PageModel<Customer> pageModel =  customerService.find(cust_name,page,rows);
		//3.返回datagrid需要的json格式的数据（规定好的接收total，rows）
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", pageModel.getTotalCount());
		map.put("rows",pageModel.getPageList());
        return map;
	}
}

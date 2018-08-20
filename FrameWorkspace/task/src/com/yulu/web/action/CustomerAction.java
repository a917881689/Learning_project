package com.yulu.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.Customer;
import com.yulu.entity.PageModel;
import com.yulu.service.CustomerService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
    /**
     * ModelDriver使用
     */
	private Customer customer = new Customer();

	private String result;
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 一页显示的数据
     */
    private Integer rows = 3;


    @org.apache.struts2.json.annotations.JSON
	public String getResult() {
		return result;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	@Resource(name="customerService")
	private CustomerService customerService;
	
	// 1.添加客户
    @Action(value="customer_save",results= {
            @Result(type="json",params={"root","result"})})
	public String save () {
        customerService.addCustomer(customer);
        result = SUCCESS;
        return SUCCESS;
	}
    @Action(value="customer_delete",results= {
            @Result(type="json",params={"root","result"})})
    public String delete () {
        customerService.delete(customer.getCust_id());
        result = SUCCESS;
        return SUCCESS;
    }
    @Action(value="customer_update",results= {
            @Result(type="json",params={"root","result"})})
    public String update () {
        customerService.update(customer);
        result = SUCCESS;
        return SUCCESS;
    }

	/**
	 * 1.分页查询所有客户
	 * @throws IOException
	 */
    @Action(value="customer_find",results= {
            @Result(type="json",params={"root","result"})})
	public String findAll() throws IOException {
		//2.调用service层的查询方法
		PageModel<Customer> pageModel =  customerService.find(customer.getCust_name(),page,rows);

		//3.返回datagrid需要的json格式的数据（规定好的接收total，rows）
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", pageModel.getTotalCount());
		map.put("rows",pageModel.getPageList());

		String jsonString = JSON.toJSONString(map);
		//4.将json采用【异步方式】返回客户端
//		result = jsonString;
//        System.out.println(jsonString);
//		return SUCCESS;

        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(jsonString);
        return NONE;
	}
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

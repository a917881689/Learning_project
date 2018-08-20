package com.yulu.web.action;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yulu.entity.User;
import com.yulu.service.UserService;
import com.yulu.util.MD5Utils;

@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String result;
	@Resource(name="userService")
	private UserService userService;
	
	@org.apache.struts2.json.annotations.JSON
	public String getResult() {
		return result;
	}
	@Override
	public User getModel() {
		return user;
	}

	@Action(value="user_save",results= {
			@Result(type="json",params={"root","result"})})
	public String save() {
		System.out.println("执行regist()方法");
		userService.add(user);
		result = SUCCESS;
		return SUCCESS;
	}
	

	@Action(value="user_delete",results= {
            @Result(type="json",params={"root","result"})})
	public String delete() {
		System.out.println("执行regist()方法");
		userService.delete(user.getId());
        result = SUCCESS;
		return SUCCESS;
	}

    @Action(value="user_update",results= {
            @Result(type="json",params={"root","result"})})
    public String update() {
        System.out.println("执行regist()方法");
        userService.update(user);
        result = SUCCESS;
        return SUCCESS;
    }

    @Action(value="user_queryById",results= {
            @Result(type="json",params={"root","result"})})
    public String queryById() {
        System.out.println("执行regist()方法");
        User queryUser = userService.queryById(this.user.getId());
        result = JSON.toJSONString(queryUser);
        return SUCCESS;
    }
}

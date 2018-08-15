package com.yosakura.web.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.yosakura.domian.User;

public class StrutsAjaxJsonAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String resultJson;
	public String strutsAjax () {
		User user = new User("咲","1234");
		resultJson = JSON.toJSONString(user);
		return SUCCESS;
	}
	
	// 用来属性设置和获取（属性注入）
	public String getResultJson() {
		return resultJson;
	}
	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}
	
}

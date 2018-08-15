package com.yosakura.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.entity.Message;
import com.yosakura.entity.MsgBrieflyMoedl;
import com.yosakura.entity.MsgWrap;
import com.yosakura.entity.PageModel;
import com.yosakura.entity.User;
import com.yosakura.service.impl.MessageServiceImpl;

public class MessageAction extends ActionSupport implements SessionAware,ModelDriven<Message> {
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	private Message msg = new Message();
	private User user = null;
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	private String result;
	public String getResult() {
		return result;
	}
	public Message getModel() {
		return msg;
	}
	public String sendMsg() {
		System.out.println("发送信息");
		System.out.println("信息:"+msg);
		if (!sendCk()) {
			result = ERROR;
			return SUCCESS;
		}
		
		msg.setSender_uid(user.getId());
		msg.setType(1);
		System.out.println("信息:"+msg);
		boolean flag = new MessageServiceImpl().sendMsg(msg);
		if (flag) {
			result = SUCCESS;
			return SUCCESS;	
		}
		result = ERROR;
		return SUCCESS;
		
	}
	// 信息非空验证
	private boolean sendCk() {
		Long uid = msg.getRecipient_uid();
		String titile = msg.getTitle();
		String content = msg.getContent();
		// 2.非空验证
		if (uid == null || titile == null || "".equals(titile) || content == null || "".equals(content) ) {
			return false;
		}
		return true;
	}
	public String querySingleMsg() {
		System.out.println("查询单个MSG详情mid："+msg.getId());
		if (msg.getId() == null) {
			result = ERROR;
			return SUCCESS;
		}
		MsgWrap querymsg = new MessageServiceImpl().querySingleMsg(msg.getId());
		String jsonString = JSON.toJSONString(querymsg);
		result = jsonString;
		System.out.println("信息json:"+jsonString);
		return SUCCESS;
		
	}
	public String queryInbox() {
		System.out.println("进入查询MSG");
		User user = (User)session.get("loginUser");
		if (user == null) {
			result = ERROR;
			return SUCCESS;
		}
		if (page <= 0) {
			page = 1;
		}
		// 设置一页显示多少条数据
		int pageSize = 6;
		PageModel<MsgBrieflyMoedl> list = new MessageServiceImpl().queryInbox(user.getId(),page,pageSize);
		if (list == null ) {
			result = NONE;
			return SUCCESS;
		}
		result = JSON.toJSONString(list);
		System.out.println("msg:"+result);
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		user = (User)session.get("loginUser");
	}
	
}

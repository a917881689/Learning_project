package com.yosakura.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yosakura.dao.impl.MessageDaoImpl;
import com.yosakura.dao.impl.UserDaoImpl;
import com.yosakura.entity.Message;
import com.yosakura.entity.MsgBrieflyMoedl;
import com.yosakura.entity.MsgWrap;
import com.yosakura.entity.PageModel;
import com.yosakura.entity.User;

public class MessageServiceImpl {
	public PageModel<MsgBrieflyMoedl> queryInbox(long uid,int page,int pageSize) {
		List<MsgBrieflyMoedl> list = new ArrayList<>();
		MessageDaoImpl mdi = new MessageDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		
		long total = mdi.queryInboxCount(uid);
		int totalPage = (int)(total%pageSize == 0?total/pageSize:total/pageSize+1);
		Map<Long,String> map = new HashMap<>();
		List<Message> querylist = mdi.queryInbox(uid,page,pageSize);
		
		long queryUID = 0;
		String senderName = null;
		User user;
		Message msg = null;
		for (int i = 0; i < querylist.size(); i++) {
			msg = querylist.get(i);
			queryUID = msg.getSender_uid();
			if (map.get(queryUID) != null) {
				senderName = map.get(queryUID);
			}else {
				user = udi.queryById(queryUID);
				senderName = user ==null ?String.valueOf(queryUID):user.getUname();
				map.put(queryUID,senderName);
			}
			list.add(
				new MsgBrieflyMoedl(
						msg.getId(),senderName, msg.getCreate_date(),
						msg.getTitle(),msg.getType()));
		}
		return list.size()>0?new PageModel<MsgBrieflyMoedl>(page,pageSize,total,totalPage,list):null;
	}

	public MsgWrap querySingleMsg(Long id) {
		System.out.println("service触发");
		MessageDaoImpl mdi = new MessageDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		
		Message msg = mdi.querySingleMsg(id);
		User user = udi.queryById(msg.getSender_uid());
		String senderName = user ==null ?String.valueOf(msg.getSender_uid()):user.getUname();
		return new MsgWrap(msg.getId(),senderName,msg.getCreate_date(),msg.getTitle(),msg.getContent());
	}

	public boolean sendMsg(Message msg) {
		MessageDaoImpl mdi = new MessageDaoImpl();
		long mid = mdi.addMsg(msg);
		return mid > 0?true:false;
	}
}

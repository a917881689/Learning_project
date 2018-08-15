package com.yosakura.entity;

import java.sql.Timestamp;

public class MsgWrap {
	private Long id;
	private String sender;
	private Timestamp create_date;
	private String title;
	private String content;
	public MsgWrap() {
		super();
	}
	public MsgWrap(Long id, String sender, Timestamp create_date, String title, String content) {
		super();
		this.id = id;
		this.sender = sender;
		this.create_date = create_date;
		this.title = title;
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MsgWrap [id=" + id + ", sender=" + sender + ", create_date=" + create_date + ", title=" + title
				+ ", content=" + content + "]";
	}
	
	
}

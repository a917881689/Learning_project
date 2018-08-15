package com.yosakura.entity;

import java.sql.Timestamp;

public class MsgBrieflyMoedl {
	private Long id;
	private String sender;
	private Timestamp create_date;
	private String title;
	private Integer type;
	public MsgBrieflyMoedl() {
		super();
	}
	public MsgBrieflyMoedl(Long id, String sender, Timestamp create_date, String title, Integer type) {
		super();
		this.id = id;
		this.sender = sender;
		this.create_date = create_date;
		this.title = title;
		this.type = type;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BrieflyMoedl [id=" + id + ", sender=" + sender + ", create_date=" + create_date + ", title=" + title
				+ ", type=" + type + "]";
	}
	
}

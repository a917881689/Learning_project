package com.yosakura.entity;

import java.sql.Timestamp;

public class Message {
	private Long id;
	private Long sender_uid;
	private Long recipient_uid;
	private Timestamp create_date;
	private String title;
	private String content;
	private Integer type;
	public Message() {
		super();
	}
	public Message(Long id, Long sender_uid, Long recipient_uid, Timestamp create_date, String title, String content,
			Integer type) {
		super();
		this.id = id;
		this.sender_uid = sender_uid;
		this.recipient_uid = recipient_uid;
		this.create_date = create_date;
		this.title = title;
		this.content = content;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSender_uid() {
		return sender_uid;
	}
	public void setSender_uid(Long sender_uid) {
		this.sender_uid = sender_uid;
	}
	public Long getRecipient_uid() {
		return recipient_uid;
	}
	public void setRecipient_uid(Long recipient_uid) {
		this.recipient_uid = recipient_uid;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sender_uid=" + sender_uid + ", recipient_uid=" + recipient_uid
				+ ", create_date=" + create_date + ", title=" + title + ", content=" + content + ", type=" + type + "]";
	}
	
	
	
}

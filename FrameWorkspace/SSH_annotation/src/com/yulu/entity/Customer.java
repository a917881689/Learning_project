package com.yulu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cst_customer")
public class Customer {
	// 客户编号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cust_id;
	// 客户名称 （若字段域数据库一致,则不需要加注解）
	// @Column(name="cust_name")
	private String cust_name;
	// 客户来源
	private String cust_source;
	// 客户所属行业
	private String cust_industry;
	// 客户级别
	private String cust_level;
	// 固定电话
	private String cust_phone;
	// 移动电话
	private String cust_mobile;
	// 
	public Customer() {
		super();
	}
	
	public Customer(Long cust_id, String cust_name, String cust_source) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
	}

	public Customer(Long cust_id, String cust_name, String cust_source, String cust_industry, String cust_level,
			String cust_phone, String cust_mobile) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
		this.cust_industry = cust_industry;
		this.cust_level = cust_level;
		this.cust_phone = cust_phone;
		this.cust_mobile = cust_mobile;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
				+ ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + "]";
	}
	
}

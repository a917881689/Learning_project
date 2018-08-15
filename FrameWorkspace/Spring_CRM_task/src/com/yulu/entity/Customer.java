package com.yulu.entity;
import java.util.HashSet;
/**
 * 客户类（一个客户对于多个联系人）
 */
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
@Table(name="cst_customer")
public class Customer {
	// 客户编号
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long cust_id;
	// 客户名称
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
	@JSONField(serialize = false)
	@OneToMany                                          //指定一对多关系
	@Basic(fetch=FetchType.EAGER)
	@Cascade(value={CascadeType.SAVE_UPDATE})         //设定级联关系
	@JoinColumn(name="lkm_cust_id")                       //指定与本类主键所对应的外表的外键
	private Set<Linkman> linkmans = new HashSet<>();
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
	public Set<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	public Customer(Long cust_id, String cust_name, String cust_source, String cust_industry, String cust_level,
			String cust_phone, String cust_mobile, Set<Linkman> linkmans) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
		this.cust_industry = cust_industry;
		this.cust_level = cust_level;
		this.cust_phone = cust_phone;
		this.cust_mobile = cust_mobile;
		this.linkmans = linkmans;
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
				+ ", cust_mobile=" + cust_mobile + linkmans+"]";
	}
	
}

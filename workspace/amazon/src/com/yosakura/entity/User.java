package com.yosakura.entity;

public class User {
	private Long id;
	private String uname;
	private String pwd;
	private Integer sex;
	private String birthday;
	private String idCard;
	private String email;
	private String moblie;
	private String address;
	private Integer utype;
	
	public User() {
		super();
	}
	
	public User(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}

	public User(Long id, String uname, String pwd, Integer sex, String birthday, String idCard, String email,
			String moblie, String address, Integer utype) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.idCard = idCard;
		this.email = email;
		this.moblie = moblie;
		this.address = address;
		this.utype = utype;
	}
	public User(String uname, String pwd, Integer sex, String birthday, String idCard, String email, String moblie,
			String address, Integer utype) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.idCard = idCard;
		this.email = email;
		this.moblie = moblie;
		this.address = address;
		this.utype = utype;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", sex=" + sex + ", birthday=" + birthday
				+ ", idCard=" + idCard + ", email=" + email + ", moblie=" + moblie + ", address=" + address + ", utype="
				+ utype + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUtype() {
		return utype;
	}
	public void setUtype(Integer utype) {
		this.utype = utype;
	}
	
}

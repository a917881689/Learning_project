package com.yosakura.entity;

import java.util.Date;

public class Student {
	private long sno;
	private String sname;
	private int age;
	private String gender;
	private Date birthday;
	private long cid;
	public Student() {
		super();
	}
	public Student(long sno, String sname, int age, String gender, Date birthday, long cid) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.cid = cid;
	}
	public long getSno() {
		return sno;
	}
	public void setSno(long sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", age=" + age + ", gender=" + gender + ", birthday="
				+ birthday + ", cid=" + cid + "]";
	}
	
}

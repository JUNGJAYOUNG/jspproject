package com.sist.vo;

import java.sql.Date;

public class MemberVO {
	private int member_no;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private Date birth;
	private String gender;
	private String member_tel;
	private String addr;
	private String email;
	private String hobby;
	public MemberVO(int member_no, String member_id, String member_pwd, String member_name, Date birth, String gender,
			String member_tel, String addr, String email, String hobby) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.birth = birth;
		this.gender = gender;
		this.member_tel = member_tel;
		this.addr = addr;
		this.email = email;
		this.hobby = hobby;
	}
	public MemberVO(int member_no, String member_id, String member_name) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_name = member_name;
	}
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}

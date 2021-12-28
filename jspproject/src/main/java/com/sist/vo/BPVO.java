package com.sist.vo;

import java.sql.Date;

public class BPVO {
	private int bp_no;
	private String bp_name;
	private String loc;
	private String bp_tel;
	private Date bp_date;
	private String sup;
	private String domain;
	private String image;
	private int register;
	private int manager_no;
	private int member_no;
	private int reco_no;
	private int bussiness_type_no;
	private String bussiness_type_name;
	private int rownum;
	public BPVO(int bp_no, String bp_name, String loc, String bp_tel, Date bp_date, String sup, String domain,
			String image, int register, int manager_no, int member_no, int reco_no, int bussiness_type_no) {
		super();
		this.bp_no = bp_no;
		this.bp_name = bp_name;
		this.loc = loc;
		this.bp_tel = bp_tel;
		this.bp_date = bp_date;
		this.sup = sup;
		this.domain = domain;
		this.image = image;
		this.register = register;
		this.manager_no = manager_no;
		this.member_no = member_no;
		this.reco_no = reco_no;
		this.bussiness_type_no = bussiness_type_no;
	}
	public BPVO(int bp_no, String bp_name, String image) {
		super();
		this.bp_no = bp_no;
		this.bp_name = bp_name;
		this.image = image;
	}
	public BPVO(int bp_no, String bp_name, int register) {
		super();
		this.bp_no = bp_no;
		this.bp_name = bp_name;
		this.register = register;
	}
	public BPVO(int bp_no, int bussiness_type_no, String bp_name) {
		super();
		this.bp_no = bp_no;
		this.bp_name = bp_name;
		this.bussiness_type_no = bussiness_type_no;
	}
	
	
	
	
	public BPVO(String bussiness_type_name, String bp_name, int bp_no ) {
		super();
		this.bussiness_type_name = bussiness_type_name;
		this.bp_name = bp_name;
		this.bp_no = bp_no;
	}
	public BPVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
	}
	public String getBp_name() {
		return bp_name;
	}
	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getBp_tel() {
		return bp_tel;
	}
	public void setBp_tel(String bp_tel) {
		this.bp_tel = bp_tel;
	}
	public Date getBp_date() {
		return bp_date;
	}
	public void setBp_date(Date bp_date) {
		this.bp_date = bp_date;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRegister() {
		return register;
	}
	public void setRegister(int register) {
		this.register = register;
	}
	public int getManager_no() {
		return manager_no;
	}
	public void setManager_no(int manager_no) {
		this.manager_no = manager_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getReco_no() {
		return reco_no;
	}
	public void setReco_no(int reco_no) {
		this.reco_no = reco_no;
	}
	public int getBussiness_type_no() {
		return bussiness_type_no;
	}
	public void setBussiness_type_no(int bussiness_type_no) {
		this.bussiness_type_no = bussiness_type_no;
	}
	public String getBussiness_type_name() {
		return bussiness_type_name;
	}
	public void setBussiness_type_name(String bussiness_type_name) {
		this.bussiness_type_name = bussiness_type_name;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	
	
}

package com.sist.vo;

import java.sql.Date;

public class FavorVO {
	private int favor_no;
	private Date favor_date;
	private int member_no;
	private int bp_no;
	public FavorVO(int favor_no, Date favor_date, int member_no, int bp_no) {
		super();
		this.favor_no = favor_no;
		this.favor_date = favor_date;
		this.member_no = member_no;
		this.bp_no = bp_no;
	}
	public FavorVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFavor_no() {
		return favor_no;
	}
	public void setFavor_no(int favor_no) {
		this.favor_no = favor_no;
	}
	public Date getFavor_date() {
		return favor_date;
	}
	public void setFavor_date(Date favor_date) {
		this.favor_date = favor_date;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
	}
	
	
}

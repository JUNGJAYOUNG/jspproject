package com.sist.vo;

import java.sql.Date;

public class ReviewVO {
	private int review_no;
	private Date review_date;
	private String comments;
	private int bp_no;
	private int member_no;
	private String member_name;
	private String bp_name;
	private int rownum;
	
	public ReviewVO(Date review_date, String comments, int bp_no, String bp_name, int rownum) {
		super();
		this.review_date = review_date;
		this.comments = comments;
		this.bp_no = bp_no;
		this.bp_name = bp_name;
		this.rownum = rownum;
	}


	public ReviewVO(int review_no, Date review_date, String comments, int bp_no, int member_no) {
		super();
		this.review_no = review_no;
		this.review_date = review_date;
		this.comments = comments;
		this.bp_no = bp_no;
		this.member_no = member_no;
	}


	public ReviewVO(int review_no, Date review_date, String comments, String bp_name) {
		super();
		this.review_no = review_no;
		this.review_date = review_date;
		this.comments = comments;
		this.bp_name = bp_name;
	}


	public ReviewVO(int review_no, Date review_date, String comments, int bp_no, int member_no, String member_name) {
		super();
		this.review_no = review_no;
		this.review_date = review_date;
		this.comments = comments;
		this.bp_no = bp_no;
		this.member_no = member_no;
		this.member_name = member_name;
	}

	public ReviewVO(Date review_date, String comments, String member_name) {
		super();
		this.review_date = review_date;
		this.comments = comments;
		this.member_name = member_name;
	}
	public ReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getBp_name() {
		return bp_name;
	}


	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}


	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
}

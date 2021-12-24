package com.sist.vo;

import java.sql.Date;

public class ReviewVO {
	private int review_no;
	private Date review_date;
	private String comments;
	private int bp_no;
	private int member_no;
	public ReviewVO(int review_no, Date review_date, String comments, int bp_no, int member_no) {
		super();
		this.review_no = review_no;
		this.review_date = review_date;
		this.comments = comments;
		this.bp_no = bp_no;
		this.member_no = member_no;
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
	
}

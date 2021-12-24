package com.sist.vo;

import java.sql.Date;

public class NoticeVO {
	private int notice_no;
	private String notice_title;
	private Date notice_date;
	private String notice_content;
	private int manager_no;
	public NoticeVO(int notice_no, String notice_title, Date notice_date, String notice_content, int manager_no) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_date = notice_date;
		this.notice_content = notice_content;
		this.manager_no = manager_no;
	}
	public NoticeVO(int notice_no, String notice_title, Date notice_date) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_date = notice_date;
	}
	public NoticeVO(int notice_no, String notice_title, String notice_content) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
	}
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getManager_no() {
		return manager_no;
	}
	public void setManager_no(int manager_no) {
		this.manager_no = manager_no;
	}
	
	
	
}

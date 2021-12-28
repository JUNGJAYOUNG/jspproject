package com.sist.vo;

import java.sql.Date;

public class QnaVO {
	private int qna_no;
	private String qna_title;
	private Date qna_date;
	private String qna_content;
	private String ans;
	private int manager_no;
	private int member_no;
	private int rownum;
	private String member_id;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public QnaVO(int qna_no, String qna_title, String member_id, Date qna_date) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.member_id = member_id;
		this.qna_date = qna_date;
	}
	public QnaVO(int qna_no, String qna_title, Date qna_date, String qna_content, String ans, int manager_no,
			int member_no) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_date = qna_date;
		this.qna_content = qna_content;
		this.ans = ans;
		this.manager_no = manager_no;
		this.member_no = member_no;
	}
	public QnaVO(int qna_no, String qna_title, String qna_content, String ans) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.ans = ans;
	}
	public QnaVO(int qna_no, String qna_title, String qna_content) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
	}
	
	public QnaVO(int qna_no, String qna_title, Date qna_date,int rownum) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_date = qna_date;
		this.rownum = rownum;
	}
	public QnaVO(String qna_title, String qna_content, int manager_no) {
		super();
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.manager_no = manager_no;
	}
	public QnaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
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
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
}

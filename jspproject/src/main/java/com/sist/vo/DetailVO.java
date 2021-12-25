package com.sist.vo;

import java.sql.Date;

public class DetailVO {
	private int bp_no;
	private String holiday;
	private String time;
	private Date start_date;
	private Date end_date;
	private String fee;
	private String company;
	private String info;
	public DetailVO(int bp_no, String holiday, String time, Date start_date, Date end_date, String fee, String company,
			String info) {
		super();
		this.bp_no = bp_no;
		this.holiday = holiday;
		this.time = time;
		this.start_date = start_date;
		this.end_date = end_date;
		this.fee = fee;
		this.company = company;
		this.info = info;
	}
	public DetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

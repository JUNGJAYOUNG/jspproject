package com.sist.vo;

public class BusinessTypeVO {
	private int bussiness_type_no;
	private String bussiness_type_name;
	public BusinessTypeVO(int bussiness_type_no, String bussiness_type_name) {
		super();
		this.bussiness_type_no = bussiness_type_no;
		this.bussiness_type_name = bussiness_type_name;
	}
	public BusinessTypeVO() {
		super();
		// TODO Auto-generated constructor stub
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
	
}

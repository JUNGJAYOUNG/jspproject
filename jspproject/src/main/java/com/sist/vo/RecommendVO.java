package com.sist.vo;

public class RecommendVO {
	private int reco_no;
	private int bp_no;
	private int bp2_no;
	public RecommendVO(int reco_no, int bp_no, int bp2_no) {
		super();
		this.reco_no = reco_no;
		this.bp_no = bp_no;
		this.bp2_no = bp2_no;
	}
	public RecommendVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReco_no() {
		return reco_no;
	}
	public void setReco_no(int reco_no) {
		this.reco_no = reco_no;
	}
	public int getBp_no() {
		return bp_no;
	}
	public void setBp_no(int bp_no) {
		this.bp_no = bp_no;
	}
	public int getBp2_no() {
		return bp2_no;
	}
	public void setBp2_no(int bp2_no) {
		this.bp2_no = bp2_no;
	}
	
}

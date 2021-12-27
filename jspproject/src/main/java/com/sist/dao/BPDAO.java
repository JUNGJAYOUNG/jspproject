package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;

public class BPDAO {
	//메인화면 추천배프
	public ArrayList<BPVO> listRecBP(){
		ArrayList<BPVO> listRecBP = new ArrayList<BPVO>();
		try {
			String sql = "select bp_no,bp_name,image from businessplace "
					+ "where bp_no in(select bp_no from "
					+ "(select f.bp_no,count(favor_no) from favor f "
					+ "group by f.bp_no) "
					+ "where rownum<3)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listRecBP.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		} 
		return listRecBP;
	}
	
	//메인화면 진행중인 행사
	public ArrayList<BPVO> listCultureNow(){
		ArrayList<BPVO> listCultureNow = new ArrayList<BPVO>();
		try {
			String sql = "select b.bp_no,b.bp_name,image from( "
					+ "select bp_name,start_date,nvl(end_date,'2099/12/31')e from( "
					+ "select business_type_no, bp_no,bp_name from businessplace where business_type_no between 5 and 11) b,detail d "
					+ "where b.bp_no = d.bp_no)t, businessplace b "
					+ "where t.bp_name=b.bp_name  and "
					+ "to_char(t.start_date, 'YYYY-MM-DD') <= to_char(sysdate, 'YYYY-MM-DD') and "
					+ "to_char(sysdate, 'YYYY-MM-DD') <= to_char(e, 'YYYY-MM-DD')";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listCultureNow.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		} 
		return listCultureNow;
	}
	
	//통합검색에서 관광 검색결과 목록
	public ArrayList<BPVO> searchTourByMain(String keyword){
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		try {
		String sql = "select b.bp_no,bp_name,image "
				+ "from businessplace b, detail d "
				+ "where b.bp_no=d.bp_no and "
				+ "business_type_no in(1,2,3,4) and "
				+ "(b.bp_name like '%'||?||'%' or d.info like '%'||?||'%')";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	//통합검색에서 문화 검색결과 목록
	public ArrayList<BPVO> searchCultureByMain(String keyword){
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		try {
		String sql = "select b.bp_no,bp_name,image "
				+ "from businessplace b, detail d "
				+ "where b.bp_no=d.bp_no and "
				+ "business_type_no in(5,6,7,8,9,10) and "
				+ "(b.bp_name like '%'||?||'%' or d.info like '%'||?||'%')";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}




}


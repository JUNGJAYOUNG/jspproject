package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;
import com.sist.vo.BusinessTypeVO;

public class BPDAO {
	public static int pageSIZE=5;
	public static int culPageSIZE=6;
	public static int totalRecord;
	public static int totalPage;
	public static int totalRecord2;
	public static int totalPage2;

	public int getApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	public int getCulApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=1 and business_type_no in (5,6,7,8,9,10)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	public int getNotApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=0";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return n;
	}
	
	public int getNextNo() {
		int no=0;
		String sql ="select nvl(max(business_no),0)+1 from businessplace";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return no;
	}
	public int insertBP(BPVO b) {
		int re=-1;
		String sql = "insert into businessplace values(?,?,?,?,sysdate,?,?,?,0,1,1,?)";
		//int no = getNextNo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBp_no());
			pstmt.setString(2, b.getBp_name());
			pstmt.setString(3, b.getLoc());
			pstmt.setString(4, b.getBp_tel());
			pstmt.setString(5, b.getSup());
			pstmt.setString(6, b.getDomain());
			pstmt.setString(7, b.getImage());
			pstmt.setInt(8, b.getBussiness_type_no());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
	
		return re;
	}
	public ArrayList<BPVO> listNotApprovedBP(int pageNUM){
		totalRecord = getNotApprovedRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord);
		System.out.println("전체페이지수:"+totalPage);
		
		int start = (pageNUM-1)*BPDAO.pageSIZE+1;
		int end = start+BPDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
	ArrayList<BPVO> list= new ArrayList<BPVO>();
		String sql = "select business_type_name,name,business_no from( "
				+ "select rownum n,business_no, business_type_name, name "
				+ "from (select business_type_no,business_no,name,register from businessplace order by business_no desc) bp, business_type bt "
				+ "where bp.business_type_no = bt.business_type_no and "
				+ "register = 0)where n between ?and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getString(1),rs.getString(2), rs.getInt(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	//수정깃허브테스트 cs
	public ArrayList<BPVO> listApprovedBP(int pageNUM){
		totalRecord2 = getApprovedRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.pageSIZE+1;
		int end = start+BPDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list= new ArrayList<BPVO>();
		String sql = "select business_type_name,name,business_no from( "
				+ "select rownum n,business_no, business_type_name, name "
				+ "from (select business_type_no,business_no,name,register from businessplace order by business_no desc) bp, business_type bt "
				+ "where bp.business_type_no = bt.business_type_no and "
				+ "register = 1)where n between ?and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getString(1),rs.getString(2), rs.getInt(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public BPVO getBP(int no) {
		BPVO b = null;
		String sql = "select * from businessplace where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b=new BPVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),0,rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return b;
	}
	
	public String changeBTN(int business_type_no) {
		String btname="";
		String sql = "select business_type_name from business_type where business_type_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, business_type_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				btname=rs.getString(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return btname;
	}
	public int updateBP(BPVO b) {
		int re =-1;
		String sql="update businessplace set name=?,loc=?,tel=?,sup=?,domain=?,image=?,business_type_no=?"
				+ " where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,b.getBp_name());
			pstmt.setString(2,b.getLoc());
			pstmt.setString(3,b.getBp_tel());
			pstmt.setString(4,b.getSup());
			pstmt.setString(5,b.getDomain());
			pstmt.setString(6,b.getImage());
			pstmt.setInt(7, b.getBussiness_type_no());
			pstmt.setInt(8, b.getBp_no());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return re;
	}
	public int updateRegister(int no) {
		int re=-1;
		String sql = "update businessplace set register=1 where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return re;
		
	}

	public int deleteBP(int no) {
		int re=-1;
		String sql = "delete from businessplace where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return re;
		
	}
	public ArrayList<BPVO>listCulture(int pageNUM){
		
		totalRecord2 = getCulApprovedRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from "
				+ "(select rownum n,business_no,name,image from "
				+ "(select business_no,name,image from businessplace "
				+ "where business_type_no in (5,6,7,8,9,10) order by business_no desc)) "
				+ "where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
		
	}



}

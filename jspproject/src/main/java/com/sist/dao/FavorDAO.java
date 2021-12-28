package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;
import com.sist.vo.FavorVO;

public class FavorDAO {
	public int getNextNo() {
		int no=0;
		String sql ="select nvl(max(favor_no),0)+1 from favor";
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
	public int cntFavor(int no) {
		int re=-1;
		String sql = "select count(*) from favor where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re= rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return re;
	}
	public int checkedFavor(int bp_no,int member_no) {
		int re=0;
		String sql = "select favor_no from favor where business_no=? and member_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bp_no);
			pstmt.setInt(2, member_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re=rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;		
	}
	public int insertFavor(FavorVO f) {
		int re=-1;
		String sql = "insert into favor values(?,sysdate,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, f.getFavor_no());
			pstmt.setInt(2, f.getBp_no());
			pstmt.setInt(3, f.getMember_no());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
	public int deleteFavor(int bp_no,int member_no) {
		int re=-1;
		String sql = "delete from favor where business_no=? and member_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bp_no);
			pstmt.setInt(2, member_no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return re;
		
	}
}

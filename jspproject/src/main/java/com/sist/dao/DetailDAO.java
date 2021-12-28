package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;

public class DetailDAO {

	public int insertDetail(DetailVO d) {
		int re =-1;
		String sql = "insert into detail values(?,?,?,?,?,?,?,?)";
		//int no=getNextNo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getHoliday());
			pstmt.setString(2, d.getTime());
			pstmt.setDate(3, d.getStart_date());
			pstmt.setDate(4, d.getEnd_date());
			pstmt.setString(5, d.getFee());
			pstmt.setString(6, d.getCompany());
			pstmt.setInt(7, d.getBp_no());
			pstmt.setString(8, d.getInfo());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return re;
	}
		
	public DetailVO getDetail(int no) {
		DetailVO d = null;
		String sql = "select * from detail where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				d=new DetailVO(rs.getInt(7),rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(8));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return d;
	}
	public int updateDetail(DetailVO d) {
		int re=-1;
		String sql = "update detail set holiday=?,time=?,start_date=?,end_date=?,fee=?,company=?,info=? "
				+ "where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getHoliday());
			pstmt.setString(2, d.getTime());
			pstmt.setDate(3, d.getStart_date());
			pstmt.setDate(4, d.getEnd_date());
			pstmt.setString(5, d.getFee());
			pstmt.setString(6, d.getCompany());
			pstmt.setString(7, d.getInfo());
			pstmt.setInt(8, d.getBp_no());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return re;
	}
	public int deleteDetail(int no) {
		int re=-1;
		String sql = "delete from detail where business_no=?";
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
}

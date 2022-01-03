package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.ReviewVO;

public class ReviewDAO {
	public static int pageSIZE=5;
	public static int totalRecord;
	public static int totalPage;
	
	public int getReviewRecord(int no) {
		int n=0;
		String sql = "select count(*) from review where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	public ArrayList<ReviewVO> listCulReview(int no,int pageNUM){
		totalRecord = getReviewRecord(no);
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord);
		System.out.println("전체페이지수:"+totalPage);
		
		int start = (pageNUM-1)*BPDAO.pageSIZE+1;
		int end = start+BPDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		String sql="select review_date, comments, member_name from("
				+ "select rownum n,review_date, comments, member_name from("
				+ "select review_date, comments, member_name from review,member "
				+ "where review.member_no=member.member_no and business_no=? order by review_date desc)) "
				+ "where n between ? and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVO(rs.getDate(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public int getNextNo() {
		int no=0;
		String sql ="select nvl(max(review_no),0)+1 from review";
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
	public int insertReview(String comments,int bp_no, int member_no) {
		int re=-1;
		String sql = "insert into review values(?,sysdate,?,?,?)";
		int no = getNextNo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2,comments);
			pstmt.setInt(3, bp_no);
			pstmt.setInt(4, member_no);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
}

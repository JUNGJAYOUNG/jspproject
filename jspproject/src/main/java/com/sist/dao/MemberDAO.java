package com.sist.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;
import com.sist.vo.FavorVO;
import com.sist.vo.MemberVO;
import com.sist.vo.QnaVO;
import com.sist.vo.ReviewVO;

public class MemberDAO {
	public static int pageSIZE=5;
	public static int pageSIZEC=4;
	public static int totalRecord1;
	public static int totalPage1;
	public static int totalRecord2;
	public static int totalPage2;
	public static int totalRecord3;
	public static int totalPage3;
	public static int totalRecord4;
	public static int totalPage4;
	
	public int getNextNo() {
		int no = 0;
		String sql = "select nvl(max(member_no),0)+1 from member";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(conn,pstmt,rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return no;
	}
	
	public int insertMember(MemberVO m) {
		int re = -1;
		
		String sql = "insert into member(member_no,member_id,member_pwd,member_name,birth,gender,member_tel,addr,email,hobby) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		int no = getNextNo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, m.getMember_id());
			pstmt.setString(3, m.getMember_pwd());
			pstmt.setString(4, m.getMember_name());
			pstmt.setDate(5, m.getBirth());
			pstmt.setString(6, m.getGender());
			pstmt.setString(7, m.getMember_tel());
			pstmt.setString(8, m.getAddr());
			pstmt.setString(9, m.getEmail());
			pstmt.setString(10, m.getHobby());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;	
	}
	public int getMemberReviewRecord(int no) {
		int n=0;
		String sql = "select count(*) from review where member_no=?";
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
			e.getMessage();// TODO: handle exception
		}
		return n;
	}
	public ArrayList<ReviewVO> getMemberReview(int no,int pageNUM){
		totalRecord1 = getMemberReviewRecord(no);
		totalPage1 = (int)Math.ceil(totalRecord1/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord1);
		System.out.println("전체페이지수:"+totalPage1);
		
		int start = (pageNUM-1)*MemberDAO.pageSIZE+1;
		int end = start+MemberDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		String sql ="select review_date,comments,business_no,name,rownum from("
				+ "select rownum n,comments, name, review_date,business_no from(select comments, name, review_date,b.business_no "
				+ "from review r , businessplace b "
				+ "where r.business_no = b.business_no and r.member_no = ? order by review_date desc)) "
				+ "where n between ? and ? order by n desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVO(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return list;
		
	}
	
	public int getMemberBPRecord(int no) {
		int n=0;
		String sql = "select count(*) from Businessplace where member_no=?";
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
			e.getMessage();// TODO: handle exception
		}
		return n;
	}
	public ArrayList<BPVO> listMemberBP(int no,int pageNUM){
		totalRecord3 = getMemberBPRecord(no);
		totalPage3 = (int)Math.ceil(totalRecord3/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord3);
		System.out.println("전체페이지수:"+totalPage3);
		
		int start = (pageNUM-1)*MemberDAO.pageSIZE+1;
		int end = start+MemberDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list= new ArrayList<BPVO>();
		String sql = "select business_no,name,register,rownum from("
				+ "select rownum n,name,register,business_no from("
				+ "select name,register,business_no from businessplace where member_no=? order by business_no)) "
				+ "where n between ? and ? order by n desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public int getMemberQnaRecord(int no) {
		int n=0;
		String sql = "select count(*) from qna where member_no=?";
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
			e.getMessage();// TODO: handle exception
		}
		return n;
	}
	public ArrayList<QnaVO> listMemberQna(int no,int pageNUM){
		totalRecord4 = getMemberQnaRecord(no);
		totalPage4 = (int)Math.ceil(totalRecord4/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord4);
		System.out.println("전체페이지수:"+totalPage4);
		
		int start = (pageNUM-1)*MemberDAO.pageSIZE+1;
		int end = start+MemberDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<QnaVO> list= new ArrayList<QnaVO>();
		String sql = "select qna_no,qna_title,qna_date,rownum from( "
				+ "select rownum n,qna_title,qna_date,qna_no from( "
				+ "select qna_title,qna_date,qna_no from qna where member_no=? order by qna_no)) "
				+ "where n between ? and ? order by n desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnaVO(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getInt(4)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public int getMemberFavorRecord(int no) {
		int n=0;
		String sql = "select count(*) from favor where member_no=?";
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
			e.getMessage();// TODO: handle exception
		}
		return n;
	}
	public ArrayList<BPVO> listMemberFavor(int no,int pageNUM){
		totalRecord2 = getMemberFavorRecord(no);
		totalPage2 = (int)Math.ceil(totalRecord2/(double)pageSIZEC);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*MemberDAO.pageSIZEC+1;
		int end = start+MemberDAO.pageSIZEC-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list= new ArrayList<BPVO>();
		
		String sql = "select business_no,name,image,rownum from("
				+ "select rownum n,name,image,business_no from("
				+ "select name , image,b.business_no from businessplace b, member m, favor f "
				+ "where b.business_no = f.business_no and f.member_no = m.member_no and "
				+ "m.member_no = ? order by favor_date desc)) "
				+ "where n between ? and ? order by rownum desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	public int deleteMember(int no) {
		int re=-1;
		String sql = "delete from Member where member_no=?";
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

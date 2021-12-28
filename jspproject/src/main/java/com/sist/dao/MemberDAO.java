package com.sist.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;

public class MemberDAO {
	public static int pageSIZE = 10;	//한 화면에 보여줄 레코드의 수 
	public static int totalRecord;		//전체 레코드의 수
	public static int totalPage;		//전체 페이지의 수
	
	//전체 레코드의 수를 반환하는 메소드
	public int getTotalRecord() {
		int n = 0;
		String sql = "select count(*) from member";
	
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return n;
	}
	//아이디 중복 검사 메소드
	public int duplicateID(String member_id){ 
		int cnt=0; 
		try{ 
			Connection conn=ConnectionProvider.getConnection(); 
			String sql = "select count(member_id) as cnt from member where member_id = ?"; 
			PreparedStatement pstmt=conn.prepareStatement(sql); 
			pstmt.setString(1, member_id); 
			ResultSet rs=pstmt.executeQuery(); 
			if(rs.next()){ 
				cnt=rs.getInt("cnt"); 
			} 
		}catch(Exception e){ 
			System.out.println("아이디 중복 확인 실패 : " + e.getMessage()); 
		}
		return cnt;
	}
	
	//아이디 찾아서 반환하는 메소드
	public String findID(String member_name, String member_tel, Date birth) {
		String member_id="";
		String sql = "select member_id from member where member_name = ? and member_tel = ? and birth = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_name);
			pstmt.setString(2, member_tel);
			pstmt.setDate(3, birth);
		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_id = rs.getString(1);
			}
			ConnectionProvider.close(conn,pstmt,rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return member_id;
	}
	
	//비밀번호 찾아서 해당 회원번호 반환하는 메소드
	public int findPwd(String member_id, String member_name, String member_tel, Date birth) {
		int member_no=0;
		String sql = "select member_no,member_pwd from member where member_id = ? and member_name = ? and member_tel = ? and birth = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_name);
			pstmt.setString(3, member_tel);
			pstmt.setDate(4, birth);
		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_no = rs.getInt(1);
			}
			ConnectionProvider.close(conn,pstmt,rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return member_no;
	}
	
	//비밀번호 수정하는 메소드
	public int updatePwd(int member_no, String member_pwd) {
		int re = -1;
		String sql = "update member set member_pwd = ? where member_no = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_pwd);
			pstmt.setInt(2, member_no);
		
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn,pstmt);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	//회원번호 반환하는 메소드
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
	
	public boolean login(String member_id, String member_pwd) {
		boolean result = false;
		String sql = "select * from member where member_id = ? and member_pwd = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pwd);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
			ConnectionProvider.close(conn,pstmt,rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return result;
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
	
	public ArrayList<MemberVO> listMember(int pageNUM){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		
		
		int start = (pageNUM-1)*MemberDAO.pageSIZE +1;
		int end = start + MemberDAO.pageSIZE-1;
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql = "select * from member where member_no between ? and ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			ResultSet rs = pstmt.executeQuery();
	
			while(rs.next()) {
				list.add(new MemberVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	public MemberVO getMember(int member_no) {
		MemberVO m = new MemberVO();
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "select * from member where member_no = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member_no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m.setMember_no(rs.getInt(1));
				m.setMember_id(rs.getString(2));
				m.setMember_pwd(rs.getString(3));
				m.setMember_name(rs.getString(4));
				m.setBirth(rs.getDate(5));
				m.setGender(rs.getString(6));
				m.setMember_tel(rs.getString(7));
				m.setAddr(rs.getString(8));
				m.setEmail(rs.getString(9));
				m.setHobby(rs.getString(10));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return m;
	}
	
}

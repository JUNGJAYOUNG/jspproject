package com.sist.dao;

import java.sql.*;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;

public class MemberDAO {
	
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
}

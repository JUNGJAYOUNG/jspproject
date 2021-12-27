package com.sist.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;

public class MemberDAO {
	public static int pageSIZE = 10;	//�� ȭ�鿡 ������ ���ڵ��� �� 
	public static int totalRecord;		//��ü ���ڵ��� ��
	public static int totalPage;		//��ü �������� ��
	
	//��ü ���ڵ��� ���� ��ȯ�ϴ� �޼ҵ�
	public int getTotalRecord() {
		int n = 0;
		String sql = "select count(*) from board";
	
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt);
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return n;
	}
	
	//ȸ����ȣ ��ȯ�ϴ� �޼ҵ�
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return list;
	}
}

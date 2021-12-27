package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.NoticeVO;
import com.sist.vo.QnaVO;

public class QnaDAO {
	public static int pageSize = 5;			
	public static int totalRecord;			
	public static int totalPage;			
	
	public int getTotalRecord() {
		int n = 0;
		String sql = "select count(*) from qna";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(conn,stmt,rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return n;
	}
	
	public ArrayList<QnaVO> listQna(int pageNUM){
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		
		int start = (pageNUM-1) * QnaDAO.pageSize +1;
		int end = start +  QnaDAO.pageSize -1;
		
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "select qna_no,qna_title,member_id,qna_date from "
					+ "(select rownum n, qna_no,qna_title,member_no,qna_date "
					+ "from (select * from qna order by qna_date desc)) a,member m "
					+ "where a.member_no = m.member_no and "
					+ "n between ? and ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnaVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4)));
			}
			ConnectionProvider.close(conn, pstmt,rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

	public QnaVO getQna(int qna_no) {
		QnaVO n = null;
        try {
        	Connection conn = ConnectionProvider.getConnection();
        	String sql = "select qna_no,qna_title,qna_content,ans from qna where qna_no=?";
        	PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,qna_no);
			ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                n = new QnaVO(
                		rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
            }
            ConnectionProvider.close(conn, pstmt,rs);
        }catch (Exception e) {
            // TODO: handle exception
        }
		return n;
	}

	public int deleteQna(int qna_no) {
		int re =-1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "delete qna where qna_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,qna_no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public int getNextNO() {
		int no = 0;
		String sql="select nvl(max(qna_no),0)+1 from qna";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt,rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return no;
	}

	public int insertQna(QnaVO q) {
		int re =-1;
		String sql = "insert into qna values (?,?,sysdate,?,null,1,1)";
		int qna_no = getNextNO();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_no);
			pstmt.setString(2,q.getQna_title());
			pstmt.setString(3,q.getQna_content());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}

	public int insertAnsQna(QnaVO q) {
		int re =-1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update qna set ans=? where qna_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getAns());
			pstmt.setInt(2, q.getQna_no());		
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}

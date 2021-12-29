package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;
import com.sist.vo.NoticeVO;

public class NoticeDAO {
	//메인페이지에서 공지사항
	public ArrayList<NoticeVO> listNotice(){
		ArrayList<NoticeVO> listNotice = new ArrayList<NoticeVO>();
		try {
			String sql = "select notice_no,notice_title,notice_date from "
					+ "(select notice_date,notice_no,notice_title from notice "
					+ "order by notice_date desc,notice_no desc) "
					+ "where rownum<=4";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listNotice.add(new NoticeVO(rs.getInt(1), rs.getString(2), rs.getDate(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return listNotice;
	}
	
	
	//통합검색에서 공지사항 출력
	public ArrayList<NoticeVO> searchNotice(String keyword){
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
		String sql = "select notice_no,notice_title,notice_date "
				+ "from notice "
				+ "where notice_title like '%'||?||'%' or notice_content like '%'||?||'%'";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new NoticeVO(rs.getInt(1), rs.getString(2), rs.getDate(3)));
		}
		ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	//통합검색에서 공지사항 검색수
	public int cntSearchNotice(String keyword) {
		int cnt = 0;
		try {
			String sql = "select count(*) from(select notice_no,notice_title,notice_date "
					+ "from notice "
					+ "where notice_title like '%'|| ? ||'%' or notice_content like '%'|| ? ||'%')";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return cnt;	
	}
	
	
	
	public static int pageSize = 5;			//한 화면에 보여줄 레코드의 수
	public static int totalRecord;			//전체 레코드의 수
	public static int totalPage;			//전체 페이지의 수
	
	//다음 공지사항 번호
	public int getNextNO() {
		int no = 0;
		String sql="select nvl(max(notice_no),0)+1 from notice";
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
	
	//공지사항 작성
	public int insertNotice(NoticeVO n) {
		int re =-1;
		String sql = "insert into notice values (?,?,sysdate,?,1)";
		int notice_no = getNextNO();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_no);
			pstmt.setString(2,n.getNotice_title());
			pstmt.setString(3,n.getNotice_content());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	//전체 레코드 수 반환 메소드
	public int getTotalRecord(String searchColum,String keyword) {
        int n = 0;
        String sql = "select count(*) from notice ";
        
        if(keyword != null) {
			
			if(searchColum.equals("notice_date")) {
				sql += "where notice_date = '"+keyword+"'";
			}else {
				sql += " where " + searchColum + " like '%"+keyword+"%'";
				System.out.println("searchColum:"+searchColum);
				System.out.println("keyword:"+keyword);
			}
		}
        
        try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                n = rs.getInt(1);
            }

            ConnectionProvider.close(conn, stmt,rs);
        }catch (Exception e) {
            System.out.println("예외발생:"+e.getMessage());
        }
        return n;
    }
	
	public ArrayList<NoticeVO> listNotice(int pageNUM, String searchColum, String keyword){
		totalRecord = getTotalRecord(searchColum,keyword);
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		
		int start = (pageNUM-1) * NoticeDAO.pageSize +1;
		int end = start +  NoticeDAO.pageSize -1;
		
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			String sql2 = "select * from notice ";
			
			if(keyword != null) {
				
				if(searchColum.equals("notice_date")) {
					sql2 += "where notice_date = '"+keyword+"'";
				}else {
					sql2 += " where " + searchColum + " like '%"+keyword+"%'";
					System.out.println("searchColum:"+searchColum);
					System.out.println("keyword:"+keyword);
				}
			}
			
			
			String sql = "select notice_no,notice_title,notice_date from( "
					+ "select rownum n, notice_no,notice_title,notice_date "
					+ "from ("+sql2+" order by notice_date desc)) "
					+ "where n between ? and ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new NoticeVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getDate(3)));
			}
			ConnectionProvider.close(conn, pstmt,rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

	public NoticeVO getNotice(int notice_no) {
		NoticeVO n = null;
        try {
        	Connection conn = ConnectionProvider.getConnection();
        	String sql = "select notice_no,notice_title,notice_content from notice where notice_no=?";
        	PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,notice_no);
			ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                n = new NoticeVO(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            ConnectionProvider.close(conn, pstmt,rs);
        }catch (Exception e) {
            // TODO: handle exception
        }
		return n;
	}

	public int deleteNotice(int notice_no) {
		int re =-1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "delete notice where notice_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,notice_no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}

	public int updateNotice(NoticeVO n) {
		int re =-1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update notice set notice_title=?,notice_content=? where notice_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_content());
			pstmt.setInt(3, n.getNotice_no());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
}

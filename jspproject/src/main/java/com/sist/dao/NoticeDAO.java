package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
}

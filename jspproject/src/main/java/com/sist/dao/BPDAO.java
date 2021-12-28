package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BPVO;

public class BPDAO {

	//메인화면 추천배프
	public ArrayList<BPVO> listRecBP(){
		ArrayList<BPVO> listRecBP = new ArrayList<BPVO>();
		try {
			String sql = "select business_no,business_name,image from businessplace "
					+ "where business_no in(select business_no from "
					+ "(select f.business_no,count(favor_no) from favor f "
					+ "group by f.business_no) "
					+ "where rownum<3)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listRecBP.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		} 
		return listRecBP;
	}
	
	//메인화면 진행중인 행사
	public ArrayList<BPVO> listCultureNow(){
		ArrayList<BPVO> listCultureNow = new ArrayList<BPVO>();
		try {
			String sql = "select b.business_name,image from( "
					+ "select business_name,start_date,nvl(end_date,'2099/12/31')e from( "
					+ "select business_type_no, business_no,business_name from businessplace where business_type_no between 5 and 11) b,detail d "
					+ "where b.business_no = d.business_no)t, businessplace b "
					+ "where t.business_name=b.business_name  and "
					+ "to_char(t.start_date, 'YYYY-MM-DD') <= to_char(sysdate, 'YYYY-MM-DD') and "
					+ "to_char(sysdate, 'YYYY-MM-DD') <= to_char(e, 'YYYY-MM-DD')";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listCultureNow.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		} 
		return listCultureNow;
	}
	
	//통합검색에서 관광 검색결과 목록
	public ArrayList<BPVO> searchTourByMain(String keyword){
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		try {
		String sql = "select b.business_no,b.business_name,image "
				+ "from businessplace b, detail d "
				+ "where b.business_no=d.business_no and "
				+ "b.business_type_no in (1,2,3,4) and "
				+ "(b.business_name like '%'||?||'%' or d.info like '%'||?||'%')";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	//통합검색에서 문화 검색결과 목록
	public ArrayList<BPVO> searchCultureByMain(String keyword){
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		try {
		String sql = "select b.business_no,b.business_name,image "
				+ "from businessplace b, detail d "
				+ "where b.business_no=d.business_no and "
				+ "business_type_no in(5,6,7,8,9,10) and "
				+ "(b.business_name like '%'||?||'%' or d.info like '%'||?||'%')";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		pstmt.setString(2, keyword);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

	public static int pageSIZE=5;
	public static int culPageSIZE=6;
	public static int totalRecord;
	public static int totalPage;
	public static int totalRecord2;
	public static int totalPage2;

	public int getApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	public int getCulApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=1 and business_type_no in (5,6,7,8,9,10)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	public int getNotApprovedRecord() {
		int n=0;
		String sql = "select count(*) from businessplace where register=0";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return n;
	}
	
	public int getNextNo() {
		int no=0;
		String sql ="select nvl(max(business_no),0)+1 from businessplace";
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
	public int insertBP(BPVO b) {
		int re=-1;
		String sql = "insert into businessplace values(?,?,?,?,sysdate,?,?,?,0,1,1,?)";
		//int no = getNextNo();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBp_no());
			pstmt.setString(2, b.getBp_name());
			pstmt.setString(3, b.getLoc());
			pstmt.setString(4, b.getBp_tel());
			pstmt.setString(5, b.getSup());
			pstmt.setString(6, b.getDomain());
			pstmt.setString(7, b.getImage());
			pstmt.setInt(8, b.getBussiness_type_no());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
	
		return re;
	}
	public ArrayList<BPVO> listNotApprovedBP(int pageNUM){
		totalRecord = getNotApprovedRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord);
		System.out.println("전체페이지수:"+totalPage);
		
		int start = (pageNUM-1)*BPDAO.pageSIZE+1;
		int end = start+BPDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
	ArrayList<BPVO> list= new ArrayList<BPVO>();
		String sql = "select business_type_name,name,business_no from( "
				+ "select rownum n,business_no, business_type_name, name "
				+ "from (select business_type_no,business_no,name,register from businessplace order by business_no desc) bp, business_type bt "
				+ "where bp.business_type_no = bt.business_type_no and "
				+ "register = 0)where n between ?and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getString(1),rs.getString(2), rs.getInt(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	public ArrayList<BPVO> listApprovedBP(int pageNUM){
		totalRecord2 = getApprovedRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)pageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.pageSIZE+1;
		int end = start+BPDAO.pageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list= new ArrayList<BPVO>();
		String sql = "select business_type_name,name,business_no from( "
				+ "select rownum n,business_no, business_type_name, name "
				+ "from (select business_type_no,business_no,name,register from businessplace order by business_no desc) bp, business_type bt "
				+ "where bp.business_type_no = bt.business_type_no and "
				+ "register = 1)where n between ?and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getString(1),rs.getString(2), rs.getInt(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public BPVO getBP(int no) {
		BPVO b = null;
		String sql = "select * from businessplace where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b=new BPVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),0,rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return b;
	}
	
	public String changeBTN(int business_type_no) {
		String btname="";
		String sql = "select business_type_name from business_type where business_type_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, business_type_no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				btname=rs.getString(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
		return btname;
	}
	public int updateBP(BPVO b) {
		int re =-1;
		String sql="update businessplace set name=?,loc=?,tel=?,sup=?,domain=?,image=?,business_type_no=?"
				+ " where business_no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,b.getBp_name());
			pstmt.setString(2,b.getLoc());
			pstmt.setString(3,b.getBp_tel());
			pstmt.setString(4,b.getSup());
			pstmt.setString(5,b.getDomain());
			pstmt.setString(6,b.getImage());
			pstmt.setInt(7, b.getBussiness_type_no());
			pstmt.setInt(8, b.getBp_no());
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return re;
	}
	public int updateRegister(int no) {
		int re=-1;
		String sql = "update businessplace set register=1 where business_no=?";
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

	public int deleteBP(int no) {
		int re=-1;
		String sql = "delete from businessplace where business_no=?";
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
	public ArrayList<BPVO>listCulture(int pageNUM){
		
		totalRecord2 = getCulApprovedRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from "
				+ "(select rownum n,business_no,name,image from "
				+ "(select business_no,name,image from businessplace "
				+ "where business_type_no in (5,6,7,8,9,10) and register=1 order by business_no desc)) "
				+ "where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
		
	}

	public int getNameBP(String business_name) {
		int re=0;
		String sql = "select business_no from businessplace where name=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, business_name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
	public int searchCntCulture(String search) {
		int re=0;
		String sql="select count(*)from businessplace "
				+ "where name like '%' || ? || '%' and "
				+ "business_type_no in (5,6,7,8,9,10) and register=1";
		try {
			Connection conn =ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	public ArrayList<BPVO>listSearchCulture(String search,int pageNUM){
		
		totalRecord2 = searchCntCulture(search);
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from"
				+ "(select rownum n,business_no,name,image from"
				+ "(select business_no,name,image from businessplace "
				+ "where name like '%' || ? || '%' "
				+ "and business_type_no in (5,6,7,8,9,10) and register=1 order by business_no desc)) "
				+ "where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
		
	}
	
	public int getCulFavorRecord() {
		int n=0;
		String sql = "select count(*) from businessplace b, "
				+ "(select business_no,nvl(count(*),0) cnt from favor group by business_no) a "
				+ "where b.business_no = a.business_no and "
				+ "business_type_no in (5,6,7,8,9,10)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()) {
				n=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	
	public ArrayList<BPVO>favorCulture(int pageNUM){
		
		totalRecord2 = getCulFavorRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name ,image from "
				+ "(select rownum n,b.business_no,name ,image "
				+ "from businessplace b, (select business_no,nvl(count(*),0) cnt from favor group by business_no) a "
				+ "where b.business_no = a.business_no and "
				+ "business_type_no in (5,6,7,8,9,10) order by cnt desc) where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public ArrayList<BPVO>nameCulture(int pageNUM){
		
		totalRecord2 = getCulApprovedRecord();
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from("
				+ "select rownum n,business_no,name,image from ("
				+ "select business_no,name,image from businessplace "
				+ "where business_type_no in (5,6,7,8,9,10)and register=1 order by name)) "
				+ "where n between ? and ? order by n";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	
	public int getCulHolidayRecord(String holiday) {
		int n=0;
		String sql ="select count(*) from businessplace "
				+ "where business_no not in "
				+ "(select business_no from detail where holiday like '%' || ? || '%') "
				+ "and business_type_no in (5,6,7,8,9,10) and register=1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, holiday);
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
	
	public ArrayList<BPVO>holidayCulture(String holiday,int pageNUM){
		
		totalRecord2 = getCulHolidayRecord(holiday);
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from("
				+ "select rownum n,business_no,name,image from businessplace "
				+ "where business_no not in "
				+ "(select business_no from detail where holiday like '%' || ? || '%')"
				+ "and business_type_no in (5,6,7,8,9,10) and register=1)"
				+ "where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, holiday);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}
	public int getCulLocRecord(String loc) {
		int n=0;
		String sql ="select count(*) from businessplace "
				+ "where loc like ? || '%' and business_type_no in (5,6,7,8,9,10) and register=1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, loc);
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
	
	public ArrayList<BPVO>locCulture(String loc,int pageNUM){
		
		totalRecord2 = getCulLocRecord(loc);
		totalPage2 = (int)Math.ceil(totalRecord2/(double)culPageSIZE);
		System.out.println("전체레코드수:"+totalRecord2);
		System.out.println("전체페이지수:"+totalPage2);
		
		int start = (pageNUM-1)*BPDAO.culPageSIZE+1;
		int end = start+BPDAO.culPageSIZE-1;
		System.out.println("s"+start);
		System.out.println("e"+end);
		
		
		ArrayList<BPVO> list = new ArrayList<BPVO>();
		String sql="select business_no,name,image from("
				+ "select rownum n,business_no,name,image from businessplace "
				+ "where loc like ? || '%' and business_type_no in (5,6,7,8,9,10) and register=1)"
				+ "where n between ? and ?";
		try {
			Connection conn = new ConnectionProvider().getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, loc);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BPVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}
		return list;
	}

}


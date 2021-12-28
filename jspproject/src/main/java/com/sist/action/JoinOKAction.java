package com.sist.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class JoinOKAction implements SistAction {

	public MemberDAO dao;
	
	public JoinOKAction() {
		dao = new MemberDAO();
	}
	
	public Date transformDate(String year,String month,String day) {
		 String date = year+"-"+month+"-"+day;
	     Date d = Date.valueOf(date);
	        
	     return d;
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO m = new MemberVO();
		
		m.setMember_no(0);
		m.setMember_id(request.getParameter("member_id"));
		m.setMember_pwd(request.getParameter("member_pwd"));
		m.setMember_name(request.getParameter("member_name"));
		
		String year = request.getParameter("yy");
		String month = request.getParameter("mm");
		String day = request.getParameter("dd");
		
		m.setBirth(transformDate(year, month, day));
		m.setGender(request.getParameter("gender"));
		m.setMember_tel(request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3"));
		m.setAddr(request.getParameter("addr"));
		m.setEmail(request.getParameter("email"));
		m.setHobby(request.getParameter("hobby"));
		
		int re=dao.insertMember(m);
		
		String viewPage="";
		if(re==1) {
			viewPage="joinOK.jsp";
		}else {
			viewPage="b.jsp";

			viewPage="error.jsp";
			request.setAttribute("msg","회원가입에 실패하였습니다.");
		}
		return viewPage;
	}

}

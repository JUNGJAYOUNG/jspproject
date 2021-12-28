package com.sist.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;

public class FindIDOKAction implements SistAction {

	public MemberDAO dao;
	
	public FindIDOKAction() {
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
		
		String viewPage="";
		String member_name=request.getParameter("member_name");
		String member_tel=request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String year=request.getParameter("yy");
		String month=request.getParameter("mm");
		String day=request.getParameter("dd");
		
		Date birth = transformDate(year, month, day);
		
		String member_id="";
		member_id = dao.findID(member_name, member_tel, birth);
		System.out.println("member_id: "+ member_id);
		
		if (!member_id.equals("")) {
			viewPage="findIDOK.jsp";
			request.setAttribute("member_id",member_id);	
		}else {
			viewPage="error.jsp";
			request.setAttribute("msg", "아이디를 찾을 수 없습니다.");
		}	
		return viewPage;
	}

}

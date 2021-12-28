package com.sist.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;

public class FindPwdOKAction implements SistAction {

	public MemberDAO dao;
	
	public FindPwdOKAction() {
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
		String member_id=request.getParameter("member_id");
		String member_name=request.getParameter("member_name");
		String member_tel=request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String year=request.getParameter("yy");
		String month=request.getParameter("mm");
		String day=request.getParameter("dd");
		
		Date birth = transformDate(year, month, day);
		
		int member_no=0;
		member_no= dao.findPwd(member_id, member_name, member_tel, birth);

		if (member_no!=0) {
			viewPage="updatePwd.jsp";
			request.setAttribute("member_no",member_no);	
		}else {
			viewPage="error.jsp";
			request.setAttribute("msg", "비밀번호를 찾을 수 없습니다.");
		}	
		return viewPage;
	}

}

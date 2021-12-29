package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;

public class LoginOKAction implements SistAction {

	public MemberDAO dao;
	
	public LoginOKAction() {
		dao = new MemberDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd");
		boolean result = dao.login(member_id, member_pwd);
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();
		int member_no = dao.getMemberNo(member_id);
		
		String viewPage="";
		if(result) {
			viewPage="start.jsp";
			session.setAttribute("member_id",member_id);
			session.setAttribute("member_no",member_no);
		}else {
			viewPage="loginFail.jsp";
		}
		return viewPage;
	}

}

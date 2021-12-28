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
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd");
		boolean result = dao.login(member_id, member_pwd);
		
		String viewPage="";
		if(result) {
			viewPage="main.jsp";
		}else {
			viewPage="login.jsp";
			request.setAttribute("msg", "로그인에 실패하였습니다. 다시 입력해주세요.");
		}
		return viewPage;
	}

}

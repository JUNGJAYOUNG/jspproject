package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;

public class UpdatePwdAction implements SistAction {

	public MemberDAO dao;
	
	public UpdatePwdAction() {
		dao = new MemberDAO();
	}
		
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String viewPage="";
		
		int member_no = Integer.parseInt(request.getParameter("member_no"));
		String member_pwd = request.getParameter("member_pwd");
		
		int re=dao.updatePwd(member_no, member_pwd);
		
		if(re == 1) {
			viewPage="updatePwdOK.jsp";
		}else {
			viewPage="error.jsp";
			request.setAttribute("msg", "비밀번호 수정에 실패하였습니다.");
		}
		return viewPage;
	}
}

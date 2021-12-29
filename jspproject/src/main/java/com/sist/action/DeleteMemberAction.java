package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;

public class DeleteMemberAction implements SistAction{
	public MemberDAO dao;
	public DeleteMemberAction() {
		dao=new MemberDAO();
	}
@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage=""; 
		int member_no= Integer.getInteger(request.getParameter("member_no"));
		int re = dao.deleteMember(member_no);
		if(re==1) {
			viewPage="deleteMemberOK.do";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "회원 삭제에 실패");
		}
		
		return viewPage;
	}
}

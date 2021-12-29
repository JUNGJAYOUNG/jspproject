package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		
		int member_no = (Integer)session.getAttribute("member_no");
		String viewPage=""; 
		int re = dao.deleteMember(member_no);
		
		if(re==1) {
			viewPage="deleteMemberOK.do";
			session.removeAttribute("member_id");
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "회원 삭제에 실패");
		}
		
		return viewPage;
	}
}

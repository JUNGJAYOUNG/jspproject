package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class UpdateMemberOKAction implements SistAction {
	public MemberDAO dao;
	public UpdateMemberOKAction() {
		dao = new MemberDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberVO m = new MemberVO();
		HttpSession session = request.getSession();
		
		int member_no = (Integer)session.getAttribute("member_no");

		m.setAddr(request.getParameter("addr"));
		m.setHobby(request.getParameter("hobby"));
		m.setEmail(request.getParameter("email"));
		m.setMember_no(member_no);
		int re = dao.updateMember(m);
		String viewPage = "";
		if(re==1) {
			viewPage = "updateMemberOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 수정에 실패");
		}
		return viewPage;
	}

}

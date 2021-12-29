package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class UpdateMemberAction implements SistAction {
	public MemberDAO dao;
	public UpdateMemberAction() {
		dao = new MemberDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage="";
		int member_no=Integer.parseInt(request.getParameter("member_no"));
		MemberVO m= dao.getMember(member_no);
		request.setAttribute("m", m);
		return "updateMember.jsp";
	}

}

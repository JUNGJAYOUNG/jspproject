package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class ListMemberAction implements SistAction {
	
	public MemberDAO dao;
	
	public ListMemberAction() {
		dao = new MemberDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNum = 1;
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		ArrayList<MemberVO> list= dao.listMember(pageNum);
		request.setAttribute("totalPage", MemberDAO.totalPage);
		request.setAttribute("list", list);
		
		return "listMember.jsp";
	}
}

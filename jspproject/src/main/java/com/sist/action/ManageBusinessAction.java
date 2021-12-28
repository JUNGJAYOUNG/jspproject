package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.vo.BPVO;

public class ManageBusinessAction implements SistAction {
	public BPDAO dao;
	public ManageBusinessAction() {
		dao = new BPDAO();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNUM =1;
		int pageNUM2=1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));
		}
		System.out.println(pageNUM);
		if(request.getParameter("pageNUM2")!=null) {
			pageNUM2=Integer.parseInt(request.getParameter("pageNUM2"));
		}
		
		
		ArrayList<BPVO> NotApprovedList = dao.listNotApprovedBP(pageNUM);
		ArrayList<BPVO> approvedList = dao.listApprovedBP(pageNUM2);
		request.setAttribute("totalPage", BPDAO.totalPage);
		request.setAttribute("totalPage2", BPDAO.totalPage2);
		request.setAttribute("NotApprovedList", NotApprovedList);
		request.setAttribute("approvedList", approvedList);
		return "manageBusiness.jsp";
		// TODO Auto-generated method stub
	}

}

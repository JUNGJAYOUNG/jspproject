package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.vo.BPVO;

public class CultureNameAction implements SistAction {
	public BPDAO dao;
	public CultureNameAction() {
		dao = new BPDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNUM =1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));
		}
		System.out.println(pageNUM);

		ArrayList<BPVO> culList=dao.nameCulture(pageNUM);
		for(BPVO b : culList) {
			System.out.println(b.getBp_name());
		}
		request.setAttribute("totalPage", BPDAO.totalPage2);
		request.setAttribute("culList", culList);
		return "cultureFavor.jsp";
	}

}

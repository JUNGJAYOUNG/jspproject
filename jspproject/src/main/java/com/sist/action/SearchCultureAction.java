package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.vo.BPVO;

public class SearchCultureAction implements SistAction {
	public BPDAO dao;
	public SearchCultureAction() {
		dao=new BPDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		System.out.println(search);
		int pageNUM =1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));
		}
		System.out.println(pageNUM);

		ArrayList<BPVO> culList=dao.listSearchCulture(search, pageNUM);
		for(BPVO c : culList) {
			System.out.println(c.getImage());
		}
		int cnt = dao.searchCntCulture(search);
		request.setAttribute("totalPage", BPDAO.totalPage2);
		request.setAttribute("culList", culList);
		request.setAttribute("search", search);
		request.setAttribute("cnt", cnt);
		return "searchCulture.jsp";
	}

}

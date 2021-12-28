package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BPDAO;
import com.sist.vo.BPVO;

public class SearchAction implements SistAction {
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String keyword = request.getParameter("keyword");
		if(keyword == null && session.getAttribute("keyword")!= null) {
			keyword = (String)session.getAttribute("keyword");
		}
		
		if(request.getParameter("keyword") != null) {
			request.getSession().setAttribute("keyword", keyword);
		}
		
		return "searchOK.jsp";
	}

}

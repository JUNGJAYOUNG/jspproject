package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.NoticeDAO;
import com.sist.vo.NoticeVO;

public class NoticeAction implements SistAction {

	public NoticeDAO dao;
	public NoticeAction() {
		dao = new NoticeDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String searchColum = request.getParameter("searchColum");
		String keyword = request.getParameter("keyword");
		
		//System.out.println("searchColum:"+searchColum); 
		System.out.println("keyword:"+keyword); 
		
		if(keyword == null && session.getAttribute("keyword")!=null) {
			searchColum = (String)session.getAttribute("searchColum");
			keyword = (String)session.getAttribute("keyword");
		}
		
		int pageNUM =1;
		if(request.getParameter("pageNUM") != null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		ArrayList<NoticeVO> list = dao.listNotice(pageNUM,searchColum,keyword);
		request.setAttribute("totalPage", NoticeDAO.totalPage);
		request.setAttribute("list", list);
		
		if(keyword != null) {
			session.setAttribute("keyword", keyword);
			session.setAttribute("searchColum", searchColum);
		}
		
		return "notice.jsp";
	}

}

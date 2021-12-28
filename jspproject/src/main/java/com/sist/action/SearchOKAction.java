package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BPDAO;
import com.sist.dao.NoticeDAO;
import com.sist.vo.BPVO;
import com.sist.vo.NoticeVO;

public class SearchOKAction implements SistAction {
	
	public BPDAO dao;
	public NoticeDAO ndao;
	
	public SearchOKAction() {
		dao = new BPDAO();
		ndao = new NoticeDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
	
		System.out.println("keyword:"+keyword);
		
		ArrayList<NoticeVO> searchNotice = ndao.searchNotice(keyword);
		request.setAttribute("searchNotice", searchNotice);
		System.out.println("공지사항검색결과:"+searchNotice.size());
		
		ArrayList<BPVO> searchTour = dao.searchTourByMain(keyword);
		request.setAttribute("searchTourByMain", searchTour);
		System.out.println("관광검색결과:"+searchTour.size());
		
		ArrayList<BPVO> searchCulture = dao.searchCultureByMain(keyword);
		request.setAttribute("searchCulture", searchCulture);
		System.out.println("문화검색결과:"+searchCulture.size());
		
		
		
		return "searchOK.jsp";
	}

}


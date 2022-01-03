package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.ReviewDAO;

public class InsertReviewTourOKAction implements SistAction {
	public ReviewDAO dao;
	public InsertReviewTourOKAction() {
		dao = new ReviewDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String comments = request.getParameter("comments");
		int no = Integer.parseInt(request.getParameter("no"));
		
		HttpSession session = request.getSession();
		int member_no = (int) session.getAttribute("member_no");
		
		int re = dao.insertReview(comments, no, member_no);
		String viewPage="";
		if(re==1) {
			viewPage="tourDetail.do?no="+no;
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "리뷰 등록에 실패");
		}
		return viewPage;
	}

}

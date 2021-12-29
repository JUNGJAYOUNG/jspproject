package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.ReviewDAO;

public class InsertReviewOKAction implements SistAction {
	public ReviewDAO dao;
	public InsertReviewOKAction() {
		dao = new ReviewDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String comments = request.getParameter("comments");
		int no = Integer.parseInt(request.getParameter("no"));
		
		int re = dao.insertReview(comments, no);
		String viewPage="";
		if(re==1) {
			viewPage="cultureDetail.do?no="+no;
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "리뷰 등록에 실패");
		}
		return viewPage;
	}

}

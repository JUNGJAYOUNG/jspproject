package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;
import com.sist.dao.QnaDAO;
import com.sist.vo.NoticeVO;
import com.sist.vo.QnaVO;

public class DetailQnaAction implements SistAction {
	public QnaDAO dao;
	public DetailQnaAction() {
		dao = new QnaDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		QnaVO q = dao.getQna(qna_no);
		request.setAttribute("q", q);
		return "detailQna.jsp";
	}

}
package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;
import com.sist.dao.QnaDAO;

public class DeleteQnaOKAction implements SistAction {
	
	public QnaDAO dao;
	public DeleteQnaOKAction() {
		dao = new QnaDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		int re = dao.deleteQna(qna_no);
		String viewPage = "";
		if(re==1) {
			viewPage = "deleteQnaOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "문의사항 삭제 실패");
		}
		return viewPage;
	}

}

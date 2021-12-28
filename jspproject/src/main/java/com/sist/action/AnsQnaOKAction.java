package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.QnaDAO;
import com.sist.vo.QnaVO;

public class AnsQnaOKAction implements SistAction {
	public QnaDAO dao;
	public AnsQnaOKAction() {
		dao = new QnaDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		QnaVO q = new QnaVO();
		q.setQna_no(Integer.parseInt(request.getParameter("qna_no")));
		q.setQna_title(request.getParameter("qna_title"));
		q.setQna_content(request.getParameter("qna_content"));
		q.setAns(request.getParameter("ans"));
		
		int re = dao.insertAnsQna(q);
		String viewPage = "";
		if(re==1) {
			viewPage = "ansQnaOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "���ǻ��� �亯 ��Ͽ� ����");
		}
		return viewPage;
	}

}

package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.NoticeDAO;
import com.sist.dao.QnaDAO;
import com.sist.vo.NoticeVO;
import com.sist.vo.QnaVO;

public class AddQnaOKAction implements SistAction {
	public QnaDAO dao;
	public AddQnaOKAction() {
		dao = new QnaDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int member_no = (Integer)session.getAttribute("member_no");
		
		QnaVO q = new QnaVO();
		//q.setQna_no(Integer.parseInt(request.getParameter("qna_no")));
		q.setMember_no(member_no);
		q.setQna_title(request.getParameter("qna_title"));
		q.setQna_content(request.getParameter("qna_content"));
		q.setAns(request.getParameter("ans"));
		
		int re = dao.insertQna(q);
		String viewPage = "";
		if(re==1) {
			viewPage = "addQnaOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "문의사항 등록에 실패");
		}
		return viewPage;
	}

}

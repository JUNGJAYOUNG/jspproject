package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;

public class DeleteNoticeOKAction implements SistAction {
	public NoticeDAO dao;
	public DeleteNoticeOKAction() {
		dao = new NoticeDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		int re = dao.deleteNotice(notice_no);
		String viewPage = "";
		if(re==1) {
			viewPage = "deleteNoticeOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 삭제 실패");
		}
		return viewPage;
	}

}

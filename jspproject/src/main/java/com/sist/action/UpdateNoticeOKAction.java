package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.NoticeDAO;
import com.sist.vo.NoticeVO;

public class UpdateNoticeOKAction implements SistAction {
	public NoticeDAO dao;
	public UpdateNoticeOKAction() {
		dao = new NoticeDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		NoticeVO n = new NoticeVO();
		n.setNotice_no(Integer.parseInt(request.getParameter("notice_no")));
		n.setNotice_title(request.getParameter("notice_title"));
		n.setNotice_content(request.getParameter("notice_content"));
	
		int re = dao.updateNotice(n);
		String viewPage = "";
		if(re==1) {
			viewPage = "updateNoticeOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 수정에 실패");
		}
		return viewPage;
	}

}

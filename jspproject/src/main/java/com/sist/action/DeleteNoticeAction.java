package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNoticeAction implements SistAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_no = Integer.parseInt( request.getParameter("notice_no"));
		request.setAttribute("notice_no", notice_no);
		return "deleteNotice.jsp";
	}

}

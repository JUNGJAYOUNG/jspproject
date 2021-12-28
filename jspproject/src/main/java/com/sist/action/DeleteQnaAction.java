package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteQnaAction implements SistAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qna_no = Integer.parseInt( request.getParameter("qna_no"));
		request.setAttribute("qna_no", qna_no);
		return "deleteQna.jsp";
	}

}

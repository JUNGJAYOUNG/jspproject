package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.QnaDAO;
import com.sist.vo.QnaVO;

public class ListQnaAction implements SistAction {

	public QnaDAO dao;
	public ListQnaAction() {
		dao = new QnaDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNUM =1;
		if(request.getParameter("pageNUM") != null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		ArrayList<QnaVO> list = dao.listQna(pageNUM);
		request.setAttribute("totalPage", QnaDAO.totalPage);
		request.setAttribute("list", list);
		return "listQna.jsp";
	}

}

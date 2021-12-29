package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;

public class DeleteBPAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public DeleteBPAction() {
		b_dao=new BPDAO();
		d_dao = new DetailDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bp_no=Integer.parseInt(request.getParameter("no"));
		
		int re1 = d_dao.deleteDetail(bp_no);
		int re2 = b_dao.deleteBP(bp_no);
		int re3 = re1+re2;
		String viewPage="";
		if(re3==2) {
			viewPage="manageBusiness.do";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "사업장 등록에 실패했습니다.");
			
		}
		return viewPage;
		
	}

}

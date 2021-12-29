package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BPDAO;

public class RegisterBPAction implements SistAction {
	public BPDAO dao;
	public RegisterBPAction() {
		dao =new BPDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bp_no=Integer.parseInt(request.getParameter("no"));
		int re = dao.updateRegister(bp_no);
		String viewPage="";
		if(re==1) {
			viewPage="registerBP.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "사업장 승인에 실패");
			
		}
		return viewPage;
	}

}

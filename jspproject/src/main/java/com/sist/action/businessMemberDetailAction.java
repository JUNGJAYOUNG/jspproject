package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;

public class businessMemberDetailAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public businessMemberDetailAction() {
		b_dao = new BPDAO();
		d_dao = new DetailDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bp_no=Integer.parseInt(request.getParameter("no"));
		BPVO b = b_dao.getBP(bp_no);
		DetailVO d = d_dao.getDetail(bp_no);
		String btname=b_dao.changeBTN(b.getBussiness_type_no());
		System.out.println(d.getFee());
		request.setAttribute("b", b);
		request.setAttribute("d", d);
		request.setAttribute("btname", btname);

		// TODO Auto-generated method stub
		return "businessMemberDetail.jsp";
	}

}

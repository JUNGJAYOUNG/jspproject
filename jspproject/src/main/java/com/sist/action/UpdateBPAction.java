package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;

public class UpdateBPAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public UpdateBPAction() {
		b_dao = new BPDAO();
		d_dao = new DetailDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bp_no=Integer.parseInt(request.getParameter("no"));
		BPVO b = b_dao.getBP(bp_no);
		DetailVO d = d_dao.getDetail(bp_no);
		String btname=b_dao.changeBTN(b.getBussiness_type_no());
		String tel = b.getBp_tel();
		String []tela=tel.split("-");
		String tel1=tela[0];
		String tel2=tela[1];
		String tel3=tela[2];
		System.out.println(d.getFee());
		request.setAttribute("b", b);
		request.setAttribute("d", d);
		request.setAttribute("tel1",tel1);
		request.setAttribute("tel2",tel2);
		request.setAttribute("tel3",tel3);
		System.out.println(tel1+tel2+tel3);
		request.setAttribute("btname", btname);
		return "updateBP.jsp";
	}

}

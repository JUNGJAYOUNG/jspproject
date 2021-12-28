package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.dao.MemberDAO;
import com.sist.vo.BPVO;
import com.sist.vo.FavorVO;
import com.sist.vo.QnaVO;
import com.sist.vo.ReviewVO;

public class MypageAction implements SistAction {
	public MemberDAO dao;
	public MypageAction() {
		dao= new MemberDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNUM1=1;
		int pageNUM2=1;
		int pageNUM3=1;
		int pageNUM4=1;
		if(request.getParameter("pageNUM1")!=null) {
			pageNUM1=Integer.parseInt(request.getParameter("pageNUM1"));
		}

		if(request.getParameter("pageNUM2")!=null) {
			pageNUM2=Integer.parseInt(request.getParameter("pageNUM2"));
		}
		if(request.getParameter("pageNUM3")!=null) {
			pageNUM3=Integer.parseInt(request.getParameter("pageNUM3"));
		}

		if(request.getParameter("pageNUM4")!=null) {
			pageNUM4=Integer.parseInt(request.getParameter("pageNUM4"));
		}
		

		ArrayList<ReviewVO> rvlist= dao.getMemberReview(3, pageNUM1);
		ArrayList<BPVO> fvlist = dao.listMemberFavor(3, pageNUM2);
		ArrayList<BPVO> bplist = dao.listMemberBP(3, pageNUM3);
		ArrayList<QnaVO> qnalist = dao.listMemberQna(3, pageNUM4);
	
		for(BPVO v : fvlist) {
			System.out.println(v.getBp_name());
		}
		 
		request.setAttribute("totalPage1", MemberDAO.totalPage1);
		request.setAttribute("totalPage2", MemberDAO.totalPage2);
		request.setAttribute("totalPage3", MemberDAO.totalPage3);
		request.setAttribute("totalPage4", MemberDAO.totalPage4);
		request.setAttribute("rvlist", rvlist);
		request.setAttribute("fvlist", fvlist);
		request.setAttribute("bplist", bplist);
		request.setAttribute("qnalist", qnalist);
		return "mypage.jsp";

	}

}

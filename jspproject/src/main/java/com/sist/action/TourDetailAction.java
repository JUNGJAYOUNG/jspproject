package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;
import com.sist.dao.FavorDAO;
import com.sist.dao.ReviewDAO;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;
import com.sist.vo.FavorVO;
import com.sist.vo.ReviewVO;

public class TourDetailAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public ReviewDAO r_dao;
	public FavorDAO f_dao;
	public TourDetailAction() {
		b_dao = new BPDAO();
		d_dao = new DetailDAO();
		r_dao= new ReviewDAO();
		f_dao=new FavorDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int bp_no=Integer.parseInt(request.getParameter("no"));
		int pageNUM =1;

		if(request.getParameter("pageNUM")!=null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		BPVO b = b_dao.getBP(bp_no);
		DetailVO d = d_dao.getDetail(bp_no);
		ArrayList<ReviewVO> r = r_dao.listCulReview(bp_no, pageNUM);
		
		String sup = b.getSup();
		System.out.println(sup);
		String  babycar="x.png";
		String babyinner="x.png";
		String dotinfo="x.png";
		String ele="x.png";
		String parking="x.png";
		String round="x.png";
		String speaking="x.png";
		String toliet="x.png";
		String wheel="x.png";
		if(sup.indexOf("유아차")!=-1) {
			babycar="babycar1.png";
		}
		if(sup.indexOf("기저귀")!=-1) {
			babyinner="babyinner1.png";
		}
		if(sup.indexOf("점자안내판")!=-1) {
			dotinfo="dotinfo1.png";
		}
		if(sup.indexOf("승강기")!=-1) {
			ele="ele1.png";
		}
		if(sup.indexOf("주차장")!=-1) {
			parking="parking1.png";
		}
		if(sup.indexOf("경사로")!=-1) {
			round="round1.png";
		}
		if(sup.indexOf("음성안내기")!=-1) {
			speaking="speaking1.png";
		}
		if(sup.indexOf("화장실")!=-1) {
			toliet="toliet1.png";
		}
		if(sup.indexOf("휠체어")!=-1) {
			wheel="wheel1.png";
		}
		
		
		request.setAttribute("babycar", babycar);
		request.setAttribute("babyinner", babyinner);
		request.setAttribute("dotinfo", dotinfo);
		request.setAttribute("ele", ele);
		request.setAttribute("parking", parking);
		request.setAttribute("round", round);
		request.setAttribute("speaking", speaking);
		request.setAttribute("toliet", toliet);
		request.setAttribute("wheel", wheel);
		
		
		int cntfavor=f_dao.cntFavor(bp_no);
		request.setAttribute("cntfavor", cntfavor);
		
		String btname=b_dao.changeBTN(b.getBussiness_type_no());
		request.setAttribute("totalPage", ReviewDAO.totalPage);
		request.setAttribute("b", b);
		request.setAttribute("d", d);
		request.setAttribute("r", r);
		
		request.setAttribute("btname", btname);
		
		for(ReviewVO re :r) {
			System.out.println(re.getReview_date());
		}
		
		HttpSession session = request.getSession();
		
		int member_no = (Integer)session.getAttribute("member_no");
		
		int re = f_dao.checkedFavor(bp_no, member_no);
		
		String image= "emptyheart.png";
		if(re!=0) {
			image="fullheart.png";
		}
		request.setAttribute("image", image);
		return "tourDetail.jsp";
	}

}

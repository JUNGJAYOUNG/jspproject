package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;
import com.sist.dao.FavorDAO;
import com.sist.dao.ReviewDAO;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;
import com.sist.vo.FavorVO;
import com.sist.vo.ReviewVO;

public class CultureDetailAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public ReviewDAO r_dao;
	public FavorDAO f_dao;
	public CultureDetailAction() {
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
		String  babycar="babycarX.png";
		String babyinner="babyinnerX.png";
		String dotinfo="dotinfoX.png";
		String ele="eleX.png";
		String parking="parkingX.png";
		String round="roundX.png";
		String speaking="speakingX.png";
		String toliet="tolietX.png";
		String wheel="wheelX.png";
		if(sup.indexOf("유아차")!=-1) {
			babycar="babycar.png";
		}
		if(sup.indexOf("기저귀")!=-1) {
			babyinner="babyinner.png";
		}
		if(sup.indexOf("점자안내판")!=-1) {
			dotinfo="dotinfo.png";
		}
		if(sup.indexOf("승강기")!=-1) {
			ele="ele.png";
		}
		if(sup.indexOf("주차장")!=-1) {
			parking="parking.png";
		}
		if(sup.indexOf("경사로")!=-1) {
			round="round.png";
		}
		if(sup.indexOf("음성안내기")!=-1) {
			speaking="speaking.png";
		}
		if(sup.indexOf("화장실")!=-1) {
			toliet="toliet.png";
		}
		if(sup.indexOf("휠체어")!=-1) {
			wheel="wheel.png";
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
		
		
		
		int re = f_dao.checkedFavor(bp_no, 3);
		
		String image= "emptyheart.png";
		if(re!=0) {
			image="fullheart.png";
		}
		request.setAttribute("image", image);
		return "cultureDetail.jsp";
	}

}

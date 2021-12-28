package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.FavorDAO;
import com.sist.vo.FavorVO;

public class ClickFavorAction implements SistAction {
	public FavorDAO dao;
	public ClickFavorAction() {
		dao = new FavorDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fv_no = dao.getNextNo();
		int bp_no = Integer.parseInt(request.getParameter("no"));
		int re = dao.checkedFavor(bp_no, 3);
		System.out.println(re);
		FavorVO v = new FavorVO();
		v.setFavor_no(fv_no);
		v.setBp_no(bp_no);
		v.setMember_no(3);
		int check=-1;
		String image= "emptyheart.png";
		
		if(re==0) {
			check=dao.insertFavor(v);
			image= "fullheart.png";
		}else {
			check=dao.deleteFavor(bp_no, 3);
			image= "emptyheart.png";
		}
		String viewPage="";
		if(check==1) {
			viewPage="cultureDetail.do?no="+bp_no;
		}else {
			viewPage="c.jsp";
		}
		request.setAttribute("image", image);
		return viewPage;
	}

}

package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BPDAO;
import com.sist.vo.BPVO;

public class CultureHolidayAction implements SistAction {
	public BPDAO dao;
	public CultureHolidayAction() {
		dao = new BPDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int pageNUM =1;
		String holiday=request.getParameter("holiday");
		if(request.getParameter("pageNUM")!=null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));
		}
		System.out.println(pageNUM);

		ArrayList<BPVO> culList=dao.holidayCulture(holiday,pageNUM);
		for(BPVO b : culList) {
			System.out.println(b.getBp_name());
		}
		request.setAttribute("holiday", holiday);
		request.setAttribute("totalPage", BPDAO.totalPage2);
		request.setAttribute("culList", culList);
		return "cultureHoliday.jsp";
	}

}

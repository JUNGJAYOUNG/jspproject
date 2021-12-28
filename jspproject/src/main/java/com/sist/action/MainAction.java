package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.sist.dao.BPDAO;
import com.sist.dao.NoticeDAO;
import com.sist.vo.BPVO;
import com.sist.vo.NoticeVO;

public class MainAction implements SistAction {
	public NoticeDAO ndao;
	public BPDAO dao;
	public MainAction() {
		ndao = new NoticeDAO();
		dao = new BPDAO();
	}
	
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<NoticeVO> listNotice = ndao.listNotice();
		System.out.println("공지사항개수:"+listNotice.size());
		request.setAttribute("listNotice", listNotice);
		
		ArrayList<BPVO> listRecBP = dao.listRecBP();
		System.out.println("추천배프개수:"+listRecBP.size());
		request.setAttribute("listRecBP", listRecBP);
		
		ArrayList<BPVO> listCultureNow = dao.listCultureNow();
		System.out.println("진행중인행사개수:"+listCultureNow.size());
		request.setAttribute("listCultureNow", listCultureNow);
		
		return "main.jsp";
	}

}

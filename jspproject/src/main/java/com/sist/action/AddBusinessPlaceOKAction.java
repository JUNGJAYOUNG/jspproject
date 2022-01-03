package com.sist.action;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BPDAO;
import com.sist.dao.DetailDAO;
import com.sist.vo.BPVO;
import com.sist.vo.DetailVO;

public class AddBusinessPlaceOKAction implements SistAction {
	public BPDAO b_dao;
	public DetailDAO d_dao;
	public AddBusinessPlaceOKAction() {
		b_dao = new BPDAO();
		d_dao = new DetailDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		int member_no = (Integer)session.getAttribute("member_no");
		System.out.println("member_no "+member_no);
		
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("upload");
		System.out.println(path);
		MultipartRequest multi= new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		BPVO b= new BPVO();
		DetailVO d = new DetailVO();
		int no = b_dao.getNextNo();
		System.out.println("no" + no);
		String []area={"����","�λ�","�뱸","��õ","����","����","���","����","���","�泲","���","����","����","����","�泲","���","������","������","���ϱ�","������","���Ǳ�","������","���α�","��õ��","�����","������","���빮��","���۱�","������","���빮��","���ʱ�","������","���ϱ�","���ı�","��õ��","��������","��걸","����","���α�","�߱�","�߶���","������","������","����","����","������","�λ�����","�ϱ�","���","���ϱ�","����","������","������","������","�߱�","�ؿ�뱸","���屺","����","�޼���","����","�ϱ�","����","������","�߱�","�޼���","��籸","����","������","����","����","����","������","�߱�","��ȭ��","������","���걸","����","����","�ϱ�","����","�����","����","����","������","�߱�","����","����","�ϱ�","�߱�","���ֱ�","������","���ؽ�","��ô��","���ʽ�","���ֽ�","��õ��","�¹��","����","�籸��","��籺","������","������","������","ö����","��â��","ȫõ��","ȭõ��","Ⱦ����","���� ���籸","���� �ϻ걸","��õ��","�����","���ֽ�","������","������","������","�����ֽ�","����õ��","��õ�� �һ籸","��õ�� ������","��õ�� ���̱�","������ �д籸","������ ������","������ �߿���","������ �Ǽ���","������ ��ȱ�","������ �ȴޱ�","�����","�Ȼ�� �ܿ���","�Ȼ�� ��ϱ�","�ȼ���","�Ⱦ�� ���ȱ�","�Ⱦ�� ���ȱ�","�����","���ν�","�ǿս�","�����ν�","��õ��","���ֽ�","���ý�","�ϳ���","ȭ����","����","���ֱ�","����","���ֱ�","��õ��","��õ��","������","���ؽ�","�����","�о��","��õ��","����","���ֽ�","���ؽ�","â����","�뿵��","��â��","����","���ر�","��û��","�Ƿɱ�","â�籺","�ϵ���","�Ծȱ�","�Ծ籺","��õ��","����","���ֽ�","���̽�","��õ��","�����","���ֽ�","�ȵ���","���ֽ�","��õ��","���׽� ����","���׽� �ϱ�","��ɱ�","������","��ȭ��","���ֱ�","������","���籺","��õ��","�︪��","������","�Ǽ���","û����","û�۱�","ĥ�","�����","���ֽ�","������","��õ��","������","������","���ﱺ","���","���ʱ�","��籺","���ȱ�","������","�žȱ�","������","���ϱ�","�ϵ���","�强��","���ﱺ","������","����","�س���","ȭ����","�����","������","������","�ͻ��","���ֽ� ������","���ֽ� �ϻ걸","������","��â��","���ֱ�","�ξȱ�","��â��","���ֱ�","�ӽǱ�","�����","���ȱ�","��������","���ֽ�","�����ֱ�","�����ֱ�","���ֽ�","����","���ɽ�","�����","�ƻ��","õ�Ƚ�","�ݻ걺","������","�ο���","��õ��","���ⱺ","���걺","û�籺","�¾ȱ�","ȫ����","��õ��","û�ֽ� ��籸","û�ֽ� �����","���ֽ�","���걺","�ܾ籺","������","������","��õ��","������","��õ��","û����"};
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=1;i<=area.length;i++) {
			map.put(i, area[(i-1)]);
		}	
		String sup="";
		int h_area1=Integer.parseInt(multi.getParameter("h_area1"));
		int h_area2=Integer.parseInt(multi.getParameter("h_area2"));
		String addr=map.get(h_area1)+map.get(h_area2);
		String loc=addr+multi.getParameter("address");
		String time="";
		String start_time=multi.getParameter("start_time");
		String end_time=multi.getParameter("end_time");
		
		if(start_time!=null&&!start_time.equals("")) {
			time=start_time;
		}
		if(end_time!=null&&!end_time.equals("")) {
			time+="~"+end_time;
		}
			
			
		String supa[]=multi.getParameterValues("sup");
		if(supa !=null) {
			for(int i=0; i<supa.length;i++) {
				sup+=supa[i];
			}
		}
		String holiday="";
		String []holidaya=multi.getParameterValues("holiday");
		if(holidaya!=null) {
			for(int i=0;i<holidaya.length;i++) {
				holiday+=holidaya[i];
			}
		}
		
		String url=multi.getParameter("url");
		String tel=multi.getParameter("tel1")+"-"+multi.getParameter("tel2")+"-"+multi.getParameter("tel3");
		String fname=multi.getFilesystemName("uploadFile");
		if(fname!=null&&!fname.equals("")) {
			b.setImage(fname);
		}
		String start=multi.getParameter("start_date");
		String end=multi.getParameter("end_date");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		LocalDate date1 = LocalDate.parse(start, formatter);
		LocalDate date2 = LocalDate.parse(end, formatter);
		
		Date start_date = java.sql.Date.valueOf(date1);
		Date end_date = java.sql.Date.valueOf(date2);
		//System.out.println(start_date);
		String fee=multi.getParameter("fee");
		String company = multi.getParameter("company");
		String info=multi.getParameter("info");
		int business_type_no=Integer.parseInt(multi.getParameter("business_type_name"));
		System.out.println("business_type_no "+business_type_no);
		String bp_name=multi.getParameter("bp_name");
		
		b.setMember_no(member_no);
		b.setBp_no(no);
		b.setBp_name(bp_name);
		b.setBussiness_type_no(business_type_no);
		b.setLoc(loc);
		b.setBp_tel(tel);
		b.setSup(sup);
		b.setDomain(url);
		d.setHoliday(holiday);
		d.setTime(time);
		d.setStart_date(start_date);
		d.setEnd_date(end_date);
		d.setFee(fee);
		d.setCompany(company);
		d.setBp_no(no);
		d.setInfo(info);
		/*
		 * System.out.println(no); System.out.println(multi.getParameter("bp_name"));
		 * System.out.println(multi.getParameter("business_type_name"));
		 * System.out.println(loc); System.out.println(tel); System.out.println(sup);
		 * System.out.println(url); System.out.println(holiday);
		 * System.out.println(time); System.out.println(start_date +"+"+ end_date);
		 * System.out.println(fee); System.out.println(company);
		 * System.out.println(info);
		 */
		int re1=b_dao.insertBP(b);
		int re2=d_dao.insertDetail(d);
		int re3=re1+re2;
		String viewPage="";
		if(re3==2) {
			viewPage="addBusinessPlaceOK.jsp";
		}
		else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "����� ��Ͽ� ����");
		}
		return viewPage;
	}

}

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
		String []area={"서울","부산","대구","인천","광주","대전","울산","강원","경기","경남","경북","전남","전북","제주","충남","충북","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구","강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군","남구","달서구","동구","북구","서구","수성구","중구","달성군","계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군","광산구","남구","동구","북구","서구","대덕구","동구","서구","유성구","중구","남구","동구","북구","중구","울주군","강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군","고양시 덕양구","고양시 일산구","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시 소사구","부천시 오정구","부천시 원미구","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","하남시","화성시","가평군","양주군","양평군","여주군","연천군","포천군","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군","경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시 남구","포항시 북구","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군","광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군","군산시","김제시","남원시","익산시","전주시 덕진구","전주시 완산구","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군","서귀포시","제주시","남제주군","북제주군","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군","제천시","청주시 상당구","청주시 흥덕구","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","진천군","청원군"};
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
			request.setAttribute("msg", "사업장 등록에 실패");
		}
		return viewPage;
	}

}

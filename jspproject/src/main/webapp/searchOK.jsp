<%@page import="com.sist.dao.NoticeDAO"%>
<%@page import="com.sist.dao.BPDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/searchOK.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

</head>
<%
	BPDAO dao = new BPDAO();
	int cnt1 = dao.cntSearchTourByMain(request.getParameter("keyword"));
	int cnt2 = dao.cntSearchCultureByMain(request.getParameter("keyword"));
	NoticeDAO ndao = new NoticeDAO();
	int cnt = ndao.cntSearchNotice(request.getParameter("keyword"));
%>
<jsp:include page="menu.jsp"/>

<body>
<h3>
	<img src="image/blank.png">
	<a>
	<img src="image/home.png">
	</a>
	&nbsp;&nbsp;>&nbsp;&nbsp;통합검색
</h3>

<div class="form-wrapper">
		<form action="searchOK.do" >
			<input type="search" name="keyword" placeholder="검색어를 입력하세요">
			<input type="hidden" name="keyword">
			<input class="btn-success" type="submit" value="검색">
		</form>
</div>
<h2>총 <%=cnt+cnt1+cnt2%>건의 검색결과가 있습니다</h3>
<hr>

<div class="notice-wrapper">

<h2>공지사항검색결과(<%=cnt%>건)</h2>
<div class="container">
<table class="table table-hover">
	<thead>
	<tr class="table-primary">
		<td>게시판번호</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${searchNotice}">
	<tr>
		<td>${c.notice_no}</td>
		<td><a href="detailMemberNotice.do?notice_no=${c.notice_no}">${c.notice_title}</a></td>
		<td>${c.notice_date}</td>
	</tr>
	</c:forEach>
	</tbody>

</table>
</div>

</div>

<hr>
<h2>관광검색결과(<%=cnt1%>건)</h2>

 <div class="swiper mySwiper">
      <div class="swiper-wrapper">
  		<c:forEach var="c" items="${searchTourByMain}">
        <div class="swiper-slide">
        	<a href="tourDetail.do?no=${c.bp_no}"><img src="upload/${c.image}"></a>
        	<p>${c.bp_name}</p>
        </div>
      	</c:forEach>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      
  </div>



<br>
<br>
<hr>

<h2>문화검색결과(<%=cnt2%>건)</h2>

<div class="swiper mySwiper">
      <div class="swiper-wrapper">
  		<c:forEach var="c" items="${searchCulture}">
        <div class="swiper-slide">
        	<a href="cultureDetail.do?no=${c.bp_no}"><img src="upload/${c.image}"></a>
        	<p>${c.bp_name}</p>
        </div>
      	</c:forEach>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      
  </div>

<br>
<br>

<jsp:include page="footer.jsp"/>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
      var swiper = new Swiper(".mySwiper", {
        slidesPerView: 3,
        spaceBetween: 30,
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
      });
</script>
</body>
</html>
<%@page import="com.sist.vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	var arr= ["banner1.png","banner2.png","banner3.png","banner4.png","banner5.jpg"]; 
	//var arr= ["test.png","logo.png"];
	var i=0;
	setInterval(function(){
		//var fname = 'url("image/'+ arr[i]+')';
		var fname = 'url("image/'+arr[i]+'")';
		console.log(i);
		console.log(fname);
		$(".main-banner").css("background",fname);
		$(".main-banner").css("background-size","100% 100%");
		i=i+1;
		if(i>=arr.length){
			i=0;
		}
	},2000);
});
</script>
</head>
<jsp:include page="menu.jsp"/>
<body>
	<div class="main-banner">
		<div class="form-wrapper">
		<form action="searchOK.do?keyword=keyword" >
			<input type="search" name="keyword" placeholder="검색어를 입력하세요">
			<input class="btn-success" type="submit" value="검색">
		</form>
		</div>
	</div>	

<hr>
<div class="notice-wrapper">
<h1>공지사항</h1>
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
	<c:forEach var="c" items="${listNotice}">
	<tr>
		<td>${c.notice_no}</td>
		<td><a href="detailMemberNotice.do?notice_no=${c.notice_no}">${c.notice_title}</a></td>
		<td>${c.notice_date}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<br>
<br>
</div>
</div>


<hr>
<h1>추천배프</h1>
<div class="swiper mySwiper">
      <div class="swiper-wrapper">
  		<c:forEach var="c" items="${listRecBP}">
        <div class="swiper-slide ">
        	<a href="tourDetail.do?no=${c.bp_no}">
        		<img src="upload/${c.image}" alt="이미지가없어요!">
        	</a>
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
<h1>진행중인 행사</h1>
<div class="swiper mySwiper">
      <div class="swiper-wrapper">
  		<c:forEach var="c" items="${listCultureNow}">
        <div class="swiper-slide">
        	<a href="cultureDetail.do?no=${c.bp_no}">
        	<img src="upload/${c.image}" alt="이미지가없어요!">
        	</a>
        	<p>${c.bp_name}</p>
        </div>
      	</c:forEach>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>   
  </div>
<br>
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
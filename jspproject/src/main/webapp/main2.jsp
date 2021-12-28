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

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	var arr= ["test.png","logo.png"];
	var i=0;
	setInterval(function(){
		//var fname = 'url("image/'+ arr[i]+')';
		var fname = 'url("image/'+arr[i]+'")';
		console.log(i);
		console.log(fname);
		$(".main-banner").css("background",fname);
		i=i+1;
		if(i>=arr.length){
			i=0;
		}
	},2000);
});
</script>
<style type="text/css">

</style>
</head>
<jsp:include page="menu.jsp"/>
<body>
	<div class="main-banner">
		<div class="form-wrapper" style="width: 500px; margin: auto;" >
		   <input type="text" class="form-control" placeholder="검색 키워드를 입력하세요!">
		    <button class="btn btn-success" type="button">찾기</button>
		</div>
</div>
<hr>
<div class="notice-wrapper">
<h1>공지사항</h1>
<div class="notice">
<table border="1">
	<thead>
	<tr>
		<td>게시판번호</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${listNotice}">
	<tr>
		<td>${c.notice_no}</td>
		<td><a href="notice.jsp?notice_no=${c.notice_no}">${c.notice_title}</a></td>
		<td>${c.notice_date}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>

<hr>





<div class="container">
  <h2>추천배프</h2>
  <c:forEach var="c" items="${listRecBP}">
  <div class="card" style="width:400px">
    <img class="card-img-top" src="image/logo.png" alt="Card image" style="width:100%" height="70%">
    <div class="card-body">
      <h4 class="card-title">${c.bp_name}</h4>
      <a href="#" class="btn btn-primary">상세보기</a>
    </div>
    </c:forEach>
  </div>
  <br>
  


<div class="card-wrapper">
<h1>추천배프</h1>
	<c:forEach var="c" items="${listRecBP}">
		<div class="card">
			<a href="#"><img src="image/${c.image}" width="200px"></a>
			<p>${c.bp_name}</p>
		</div>
	</c:forEach>
</div>	

<hr>
<h2>진행중인 행사</h2>
<div class="card-wrapper">
	<c:forEach var="c" items="${listCultureNow}">
		<div class="card">
			<a href="#"><img src="image/${c.image}" width="200px"></a>
			<p>${c.bp_name}</p>
		</div>
	</c:forEach>
</div>	


<jsp:include page="footer.jsp"/>
</body>
</html>
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
</head>
<jsp:include page="menu.jsp"/>
<body>
	<%
		String re = (String)session.getAttribute("member");
	
		if(re==null)
		{
			response.sendRedirect("login.jsp");
		}
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");

	%>
	<h2><%=name %> 회원님 환영합니다.</h2>
	<hr>
	<a href="listMember.do">1번째 서비스</a><br>
	<div class="main-banner">
		<div class="form-wrapper">
		<form action="searchOK.do?keyword=keyword" >
			<input type="search" name="keyword" placeholder="검색어를 입력하세요">
			<input type="submit" value="검색">
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
		<td><a href="notice.jsp?notice_no=${c.notice_no}">${c.notice_title}</a></td>
		<td>${c.notice_date}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>

<hr>

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
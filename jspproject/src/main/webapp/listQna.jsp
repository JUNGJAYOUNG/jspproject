<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	div{
		width: 60%;
		margin: auto;
	}
	
	a{
		color: white;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<br>
	<br>
	<br>
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;문의사항 관리</h3>
	<br>
	<br>
	<br>
	<br>
	
	<div>
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">아이디</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="q" items="${list }">
	    <tr class="table-primary">
	      <td>${q.qna_no }</td>
	      <td><a href="ansQna.do?qna_no=${q.qna_no }">${q.qna_title }</a></td>
	      <td>${q.member_id}</td>
	      <td>${q.qna_date}</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</div>
	
	<br>
	<br>
	<div style="width:5rem; margin:auto;">
		<c:forEach var="i" begin="1" end="${totalPage }">
			<a href="listQna.do?pageNUM=${i }" style="color: green;">${i }</a>&nbsp;&nbsp;
		</c:forEach>
	</div>
	<br>
	<hr>
	<form action="addQna.do" method="post">
		<button type="submit" class="btn btn-primary">문의사항 등록(마이페이지로 이동)</button>
	</form>
	<form action="detailQna.do?qna_no=2" method="post">
		<button type="submit" class="btn btn-primary">문의사항 확인(마이페이지로 이동)</button>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>
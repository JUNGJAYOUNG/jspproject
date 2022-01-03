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
	a{
		color: white;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">문의사항</li>
	</ol>
	<br>
	<br>
	<br>
	
	<div style="width:80rem;margin:auto;">
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
	      <td><a href="ansQna.do?qna_no=${q.qna_no }" style="color: white;">${q.qna_title }</a></td>
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
	<br>
	<br>
	<br>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>
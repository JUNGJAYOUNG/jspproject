<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<jsp:include page="menu.jsp"/>
<body>
<form action="searchOK.do">
		<input type="search" name="keyword" placeholder="검색어를 입력하세요">
		<input type="hidden" name="keyword">
		<input type="submit" value="검색">
</form>
<hr>
<div>
<div>

</div>
</div>
<h2>공지사항검색결과</h2>
<div class="container">
<table border="1">
	<thead >
	<tr>
		<td>게시판번호</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${searchNotice}">
	<tr>
		<td>${c.notice_no}</td>
		<td>${c.notice_title}</td>
		<td>${c.notice_date}</td>
	</tr>
	</c:forEach>
	</tbody>

</table>
</div>

<h2>관광검색결과</h2>
<table border="1">
	<thead>
	<tr>
		<td>게시판번호</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${searchTourByMain}">
	<tr>
		<td>${c.bp_no}</td>
		<td>${c.bp_name}</td>
		<td>${c.image}</td>
	</tr>
	</c:forEach>
	</tbody>

</table>
<h2>문화검색결과</h2>
<table border="1">
	<thead>
	<tr>
		<td>게시판번호</td>
		<td>제목</td>
		<td>작성일</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${searchCulture}">
	<tr>
		<td>${c.bp_no}</td>
		<td>${c.bp_name}</td>
		<td>${c.image}</td>
	</tr>
	</c:forEach>
	</tbody>

</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
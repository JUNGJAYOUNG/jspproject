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
	#title{
		font-size: 32px;
		font-style: bold;
	}
	.container{
		width: 70%;
	}

</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="manager.do">관리자페이지</a></li>
	  <li class="breadcrumb-item active">사업장관리</li>
	</ol>
	<br>
	<br>
	<div class="container">
		<h1>미승인 사업장</h1>
		<table class="table table-hover">
			<tr class="table-active">
				<th>번호</th>
				<th>사업장종류</th>
				<th>사업장명</th>
				<th>상세정보</th>
			</tr>
			<c:forEach var="n" items="${NotApprovedList }">
				<tr>
					<td>${n.bp_no }</td>
					<td>${n.bp_name }</td>
					<td>${n.business_type_name }</td>
					<td><a href="businessDetail.do?no=${n.bp_no }"><input type="button" value="열람" class="btn btn-primary"></a></td>
				</tr>
			
			</c:forEach>
		</table>
		<div class="page">
			<c:forEach var="i" begin="1" end="${totalPage }">
			<a href="manageBusiness.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<br>
		<br>
		<h1>승인 사업장</h1>
		<table class="table table-hover">
			<tr class="table-active">
				<th>번호</th>
				<th>사업장종류</th>
				<th>사업장명</th>
				<th>상세정보</th>
			</tr>
			<c:forEach var="a" items="${approvedList }">
				<tr>
					<td>${a.bp_no }</td>
					<td>${a.bp_name }</td>
					<td>${a.business_type_name }</td>
					<td><a href="businessDetail.do?no=${a.bp_no }"><input type="button" value="열람" class="btn btn-primary"></a></td>
				</tr>
			</c:forEach>
			
		</table>
		<div class="page">
			<c:forEach var="i" begin="1" end="${totalPage2 }">
			<a href="manageBusiness.do?pageNUM2=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>

	</div>
	<jsp:include page="footer.jsp"/>
</body>

</html>
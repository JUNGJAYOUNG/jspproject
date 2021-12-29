<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="sessionLogin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">

	.card{
		position: relative;
		float: left;
		width: 20%;
		height: 180px;
		margin: 20px;
		border: 1px solid #ofofof33;
		text-align: center;
	}
	#paging{
		padding-top: 100px;
		padding-left: 45%;
	}
	.page{
		padding-left: 45%;
	}
</style>

</head>

<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">마이페이지</li>
	</ol>
	<br>
	<br>
	<div class="container">
		<h1>내가 작성한 한줄후기</h1>
		<table class="table table-hover">
			<tr class="table-active">
				<th>번호</th>
				<th>내용</th>
				<th>배프명</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="r" items="${rvlist }">
				<tr>
					<td>${r.rownum }</td>
					<td>${r.comments }</td>
					<td><a href="cultureDetail.do?no=${r.bp_no }">${r.bp_name }</a></td>
					<td>${r.review_date }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="page">
			<c:forEach var="i" begin="1" end="${totalPage1 }">
			<a href="mypage.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<br>
		<br>
		<br>
		<h1>즐겨찾기 목록</h1>
		<c:forEach var="f" items="${fvlist }">
			<div class="card">
				<a href="cultureDetail.do?no=${f.bp_no }">
					<img src="upload/${f.image }" style="width: 100%; height: 180px;">
				</a>
				<div class="words">
					<h2>${f.bp_name }</h2>
				</div>
			</div>	
		</c:forEach>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<br>
		<div id="paging" >
			<c:forEach var="i" begin="1" end="${totalPage2 }">
				<a href="culture.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>		
		<br>
		<br>
		<br>
		
		<h1>내가 등록한 사업장</h1>
		<table class="table table-hover">
			<tr class="table-active">
				<th>번호</th>
				<th>배프명</th>
				<th>승인여부</th>
			</tr>
			<c:forEach var="b" items="${bplist }">
				<tr>
					<td>${b.rownum }</td>
					<td><a href="businessMemberDetail.do?no=${b.bp_no }">${b.bp_name }</a></td>
					<td>${b.register }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="page">
			<c:forEach var="i" begin="1" end="${totalPage3 }">
			<a href="mypage.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<br>
		<br>
		<br>
		<h1>내가 작성한 문의사항</h1>
		<table class="table table-hover">
			<tr class="table-active">
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="q" items="${qnalist }">
				<tr>
					<td>${q.rownum}</td>
					<td><a href="detailQna.do?qna_no=${q.qna_no}">${q.qna_title }</a></td>
					<td>${q.qna_date }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="page">
			<c:forEach var="i" begin="1" end="${totalPage4 }">
			<a href="mypage.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div>
		<button class="btn btn-primary" onclick="location.href='updateMember.do'">회원정보 수정</button>
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<!-- <button class="btn btn-primary" onclick="location.href='deleteMember.do'">회원 탈퇴</button> -->
		</div>
		<jsp:include page="footer.jsp"/>
</body>
</html>
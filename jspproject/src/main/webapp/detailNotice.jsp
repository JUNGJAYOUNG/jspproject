<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">
</script>
<style type="text/css">
	form{
		display: inline;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>

	<ol class="breadcrumb">
		  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
		  <li class="breadcrumb-item"><a href="manager.do">관리자페이지</a></li>
		  <li class="breadcrumb-item active">공지사항</li>
	</ol>
	<br>
	<br>
	<br>
	<br>
		<div class="card text-white bg-primary mb-3" style="width: 60rem;margin: auto">
		<input type="hidden" name="qna_no" value="${n.notice_no }">
		  <div class="card-header">${n.notice_no }</div>
		  <div class="card-body">
		    <h4 class="card-title">${n.notice_title }</h4>
		  </div>
		</div>

	 <div class="form-group" style="width: 60rem;margin: auto">
	     <label for="exampleTextarea" class="form-label mt-4"></label>
	     <textarea class="form-control" id="exampleTextarea" rows="3" name="ans"  maxlength="1000" style="height: 15rem">${content }</textarea>
	  </div>
	
	<br>
	<div style="width: 15rem;margin: auto;">
		<button type="submit" class="btn btn-primary" onclick="location.href='updateNotice.do?notice_no=${n.notice_no }'">수정</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='deleteNotice.do?notice_no=${n.notice_no }'">삭제</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='notice.do?notice_no=${n.notice_no }'">목록</button>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>
</body>
</html>
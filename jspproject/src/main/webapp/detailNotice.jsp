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
	<!--  
	제목<textarea rows="10" cols="80" readonly="readonly">${n.notice_title }</textarea><br>
	내용<textarea rows="10" cols="80" readonly="readonly">${n.notice_content }</textarea><br>
	 -->
	
	<div class="card border-primary mb-3" style="max-width: 60rem;margin: auto">
	  <div class="card-header">${n.notice_title }</div>
	  <div class="card-body">
	    <!-- <h4 class="card-title">${n.notice_title }</h4> -->
	    <p class="card-text">${content }</p>
	  </div>
	</div>
	<br>
	<div style="width: 15rem;margin: auto;">
		<button type="submit" class="btn btn-primary" onclick="location.href='updateNotice.do?notice_no=${n.notice_no }'">수정</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='deleteNotice.do?notice_no=${n.notice_no }'">삭제</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='notice.do?notice_no=${n.notice_no }'">목록</button>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>
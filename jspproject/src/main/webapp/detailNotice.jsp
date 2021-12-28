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
	<br>
	<br>
	<br>
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;공지사항</h3>
	<br>
	<br>
	<br>
	<br>
	<!--  
	제목<textarea rows="10" cols="80" readonly="readonly">${n.notice_title }</textarea><br>
	내용<textarea rows="10" cols="80" readonly="readonly">${n.notice_content }</textarea><br>
	-->
	
	<div class="card border-primary mb-3" style="max-width: 60rem;margin: auto">
	  <div class="card-header">${n.notice_title }</div>
	  <div class="card-body">
	    <!-- <h4 class="card-title">${n.notice_title }</h4> -->
	    <p class="card-text">${n.notice_content }</p>
	  </div>
	</div>
	
	<hr>
	<div style="width: 15rem;margin: auto;">
		<button type="submit" class="btn btn-primary" onclick="location.href='updateNotice.do?notice_no=${n.notice_no }'">수정</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='deleteNotice.do?notice_no=${n.notice_no }'">삭제</button>
		<button type="submit" class="btn btn-primary" onclick="location.href='notice.do?notice_no=${n.notice_no }'">목록</button>
	</div>
</body>
</html>
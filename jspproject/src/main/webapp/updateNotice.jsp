<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">

</style>
</head>
<body>
	<br>
	<br>
	<br>
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;공지사항&nbsp;&nbsp;>&nbsp;&nbsp;공지사항 수정</h3>
	<br>
	<br>
	
	<form action="updateNoticeOK.do" method="post" id="f" style="width: 60rem; margin: auto;">
		<input type="hidden" name="notice_no" value="${n.notice_no }">
		<div class="form-group">
	      <label for="exampleTextarea" class="form-label mt-4">제목</label>
	      <textarea class="form-control" id="notice_title" rows="3" name="notice_title">${n.notice_title }</textarea><br>
	      <label for="exampleTextarea" class="form-label mt-4">내용</label>
	      <textarea class="form-control" id="notice_content" rows="10"name="notice_content">${n.notice_content }</textarea><br>
	    	<div style="width: 10rem;margin: auto;">
		    	<button type="submit" class="btn btn-primary">수정</button>
		    	<button type="submit" class="btn btn-primary" onclick="location.href='notice.do'">취소</button>
		    </div>
	    </div>
    </form>
	
</body>
</html>
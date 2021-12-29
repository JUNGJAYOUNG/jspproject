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
<jsp:include page="menu.jsp"/>

	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="listQna.do">문의사항</a></li>
	  <li class="breadcrumb-item active">문의사항 등록</li>
	</ol>

	<br>
	<br>
	
	<form action="addQnaOK.do" method="post">
		<input type="hidden" name="qna_no" value="${q.qna_no }">
		<div class="form-group" style="width: 60rem;margin: auto;">
	      <label for="exampleTextarea" class="form-label mt-4">제목</label>
	      <textarea class="form-control" id="notice_title" rows="3" name="qna_title"  maxlength="30"></textarea><br>
	      <label for="exampleTextarea" class="form-label mt-4">내용</label>
	      <textarea class="form-control" id="notice_content" rows="10"name="qna_content"  maxlength="1000"></textarea><br>
	    </div>
	    <div style="width: 10rem;margin: auto;">
	    	<button type="submit" class="btn btn-primary" style="width: 10rem;margin: auto;">등록</button>
	    </div>
    </form>

    <jsp:include page="footer.jsp"/>

</body>
</html>
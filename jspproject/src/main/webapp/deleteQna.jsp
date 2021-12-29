<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	form{
		display: inline;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
<br>
	<br>
	<br>
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;문의사항&nbsp;&nbsp;>&nbsp;&nbsp;문의사항 삭제</h3>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="listQna.do">문의사항</a></li>
	  <li class="breadcrumb-item active">문의사항 삭제</li>
	</ol>
	<div class="card text-white bg-primary mb-3" style="max-width: 60rem;margin: auto;">
	  <div class="card-header">문의사항 번호: ${qna_no }</div>
	  <div class="card-body">
	    <h4 class="card-title">해당 문의사항 게시글을 정말로 삭제하시겠습니까?</h4>
	    <p class="card-text">삭제 시 복구가 불가능 합니다.</p>
	  </div>
	</div>
	<!-- 
	<form action="deleteQnaOK.do" method="post">
		<input type="hidden" name="qna_no" value="${qna_no }">
		<button type="submit" class="btn btn-primary">삭제</button>
	</form>
	<form action="ansQna.do?qna_no=${qna_no }" method="post">
		<button type="submit" class="btn btn-primary">취소</button>
	</form>
	 -->
	<div style="width: 10rem;margin: auto;">
		<form action="deleteQnaOK.do" method="post">
			<input type="hidden" name="qna_no" value="${qna_no }">
			<button type="submit" class="btn btn-primary">삭제</button>
		</form>
		<form action="listQna.do" method="post">
			<button type="submit" class="btn btn-primary">취소</button>
			<!-- 마이페이지로 이동 수정 -->
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
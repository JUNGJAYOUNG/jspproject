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
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;문의사항 확인</h3>
	<br>
	<br>
	<br>
	<br>
	<div class="card mb-3" style="width: 60rem;margin: auto;">
	  <h3 class="card-header"><span class="badge bg-primary">제목</span>     ${q.qna_title }</h3>

	  <div class="card-body">
	    <p class="card-text"><span class="badge bg-primary">내용</span>     ${content }</p>
	  </div>
	   
	  <div class="card-footer text-muted">
	  <span class="badge bg-primary">답변</span>     ${q.ans }
	  </div>
	</div>

	<form action="deleteQna.do?qna_no=${q.qna_no }" method="post">
		<div style="width: 5rem;margin: auto;">
			<button type="submit" class="btn btn-primary">삭제</button>
		</div>
	</form>
<jsp:include page="footer.jsp"/> 
</body>
</html>
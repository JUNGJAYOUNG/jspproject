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

	<ol class="breadcrumb">
		  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
		  <li class="breadcrumb-item active">문의사항 확인</li>
	</ol>
	<div class="card mb-3" style="width: 60rem;margin: auto;">
	  <h3 class="card-header"><span class="badge bg-primary">제목</span>     ${q.qna_title }</h3>

	  <div class="card-body">
	    <p class="card-text"><span class="badge bg-primary">내용</span>     ${q.qna_content }</p>
	  </div>
	  
	  <div class="card-footer text-muted">
	  <span class="badge bg-primary">답변</span>     ${q.ans }
	  </div>
	</div>
	<br>
	<br>
	<br>
	<form action="deleteQna.do?qna_no=${q.qna_no }" method="post">
		<div style="width: 5rem;margin: auto;">
			<button type="submit" class="btn btn-primary">삭제</button>
		</div>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>
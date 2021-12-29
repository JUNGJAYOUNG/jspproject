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
	<br>
	<br>
	<br>
	<br>
	<div class="card text-white bg-primary mb-3" style="width: 60rem;margin: auto">
		 <input type="hidden" name="qna_no" value="${q.qna_no }">
		 <div class="card-header">${q.qna_title }</div>
		 <div class="card-body">
		    <h4 class="card-title">${content }</h4>
		  </div>
	</div>

	<div class="form-group" style="width: 60rem;margin: auto">
	     <label for="exampleTextarea" class="form-label mt-4">답변</label>
	     <textarea class="form-control" id="exampleTextarea" rows="3" name="ans"  maxlength="1000" style="height: 15rem" readonly="readonly">${q.ans }</textarea>
	</div>
	<br>
	<br>
	<br>
	<form action="deleteQna.do?qna_no=${q.qna_no }" method="post">
		<div style="width: 5rem;margin: auto;">
			<button type="submit" class="btn btn-primary">삭제</button>
		</div>
	</form>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>

</body>
</html>
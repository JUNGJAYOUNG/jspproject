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
	  <li class="breadcrumb-item active">문의사항 답변등록</li>
	</ol>
	<br>
	<br>
	<br>
	
	<form action="ansQnaOK.do" method="post" >
		<div class="card text-white bg-primary mb-3" style="width: 60rem;margin: auto">
		<input type="hidden" name="qna_no" value="${q.qna_no }">
		  <div class="card-header">${q.qna_title }</div>
		  <div class="card-body">
		    <h4 class="card-title">${q.qna_content }</h4>
		    <p class="card-text">문의사항 번호: ${q.qna_no }</p>
		  </div>
		</div>
	<br>
	<br>
	 <div class="form-group" style="width: 60rem;margin: auto">
	     <label for="exampleTextarea" class="form-label mt-4">답변</label>
	     <textarea class="form-control" id="exampleTextarea" rows="3" name="ans"  maxlength="1000" style="height: 15rem">${q.ans }</textarea>
	     <br>
	     <br>
	    <div style="width: 10rem;margin: auto;">
	   		<button type="submit" class="btn btn-primary">등록</button>
			<button type="submit" class="btn btn-primary" onclick="location.href='listQna.do'">목록</button>
		</div>
	  </div>
    </form>

	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>

</body>
</html>
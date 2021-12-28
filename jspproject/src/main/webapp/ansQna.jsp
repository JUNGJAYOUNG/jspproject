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
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;문의사항&nbsp;&nbsp;>&nbsp;&nbsp;문의사항 답변등록</h3>
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
	<br>
	
	 <div class="form-group" style="width: 60rem;margin: auto">
	     <label for="exampleTextarea" class="form-label mt-4">답변</label>
	     <textarea class="form-control" id="exampleTextarea" rows="3" name="ans"  maxlength="1000">${q.ans }</textarea>
	     <br>
	     <br>
	    <div style="width: 10rem;margin: auto;">
	   		<button type="submit" class="btn btn-primary">등록</button>
			<button type="submit" class="btn btn-primary" onclick="location.href='listQna.do'">목록</button>
		</div>
	  </div>
    </form>
	
	
	
	
</body>
</html>
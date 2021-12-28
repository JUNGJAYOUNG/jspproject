<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String notice_no = request.getParameter("notice_no");
%>
<%=notice_no %>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	
	#date{
		visibility: hidden;
		display:none;
	}
	
	a{
		color: white;
	}
	/*
	button{
		float: right;
	}
	*/
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

var flag = "search";
function pro(){
	$("#keyword").val( $("#search").val()  );
	if(flag == "date"){
		$("#keyword").val( $("#date").val()  );
	}
	document.f.submit();
}

$(function(){
	
	
	$("#searchColum").change(function(){
		var re = $(this).val();
		console.log(re);
		if(re == "notice_date"){
			$("#date").css("visibility","visible");
			$("#search").css("visibility","hidden");
			
			$("#date").css("display","inline");
			$("#search").css("display","none");
			
			flag = "date";
		}else{
			$("#date").css("display","hidden");
			$("#search").css("visibility","visible");
			
			$("#date").css("display","none");
			$("#search").css("display","inline");
			flag = "search";
		}
	});
	
	
});

</script>
</head>
<body>
<form  action="addNotice.do" method="post">
	<br>
	<br>
	<br>
	<h3><img src="image/blank.png"><a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;공지사항</h3>
	<br>
	<br>
	<br>
	<br>
	
	<div style="width: 60rem;margin: auto;">
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <!-- <th scope="col">Type</th> -->
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="n" items="${list }">
	    <tr class="table-primary">
	     <!-- <th scope="row">Primary</th> --> 
	      <td>${n.notice_no }</td>
	      <td><a href="detailNotice.do?notice_no=${n.notice_no }">${n.notice_title }</a></td>
	      <td>${n.notice_date }</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<br>
		<button type="submit" class="btn btn-primary" style="float:right;">작성하기</button>
	</div>
	<br>
	<br>
	<br>
	</form>	
	
	<form name="f" action="notice.do" method="post" class="d-flex" style="width: 300px;margin: auto;" >
		<select name="searchColum" id="searchColum">
			<option value="notice_title">제목</option>
			<option value="notice_content">내용</option>
			<option value="notice_date">작성일</option>			
		</select>
		
		<input type="search" name="search" id="search" class="form-control me-sm-2">
		<input type="date" name="date" id="date" style="width: 400px;margin: auto;">
		<input type="hidden" name="keyword" id="keyword">
		<!-- <input type="button" value="검색" onclick="pro();"> -->
		<button type="submit" class="btn btn-primary" onclick="pro();" style="width: 200px;">검색</button>
	</form>	
	<br>
	<br>
	<br>
	<div style="width:5rem; margin:auto;">
		<c:forEach var="i" begin="1" end="${totalPage }">
			<a href="notice.do?pageNUM=${i }" style="color: green;">${i }</a>&nbsp;&nbsp;
		</c:forEach>
	</div>
	

>>>>>>> branch 'master' of https://github.com/yaps1/jspproject.git
</body>
</html>
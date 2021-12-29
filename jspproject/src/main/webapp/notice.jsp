<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="menu.jsp"/>
<form  action="addNotice.do" method="post">
	<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">공지사항</li>
	</ol>
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
	      <td><a href="detailNotice.do?notice_no=${n.notice_no }" style="color: white;">${n.notice_title }</a></td>
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
	
	<jsp:include page="footer.jsp"/>

</body>
</html>
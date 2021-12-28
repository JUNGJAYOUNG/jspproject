<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">
/* function del(no){
	  var is = confirm("정말삭제하시겠습니까?");  확인을 누르면 이동, 취소누르면 아무 이벤트도 발생안함.
	  if(is){
	  
	   location="deleteBP.do?no="+no;
	   return true;
	  }
	  else{
	   return false;
	  }
	  
	 } */
</script>
<style type="text/css">
	#title{
		font-size: 32px;
		font-style: bold;
	}
	.container{
		width: 70%;
	}
	.button{
		
	}
</style>
</head>
<body>

	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="mypage.do">마이페이지</a></li>
	  <li class="breadcrumb-item active">상세정보</li>
	</ol>
	<br>
	<br>
	<div class="container">
		<table class="table table-hover">
			<tr>
				<th class="table-success">사업장 종류</th>
				<td>${btname }</td>
			</tr>
			<tr>
				<th class="table-success">사업장 이름</th>
				<td>${b.bp_name }</td>
			</tr>
			<tr>
				<th class="table-success">지역</th>
				<td>${b.loc }</td>
			</tr>
			<tr>
				<th class="table-success">URL</th>
				<td>${b.domain }</td>
			</tr>
			<tr>
				<th class="table-success">사업장 전화번호</th>
				<td>${b.bp_tel }</td>
			</tr>
			<tr>
				<th class="table-success">시설지원</th>
				<td>${b.sup }</td>
			</tr>
			<tr>
				<th class="table-success">휴무일</th>
				<td>${d.holiday }</td>
			</tr>
			<tr>
				<th class="table-success">영업시간</th>
				<td>${d.time }</td>
			</tr>
			<tr>
				<th class="table-success">기간</th>
				<td>${d.start_date }&nbsp;~&nbsp;${d.end_date }</td>
			</tr>
			<tr>
				<th class="table-success">입장료</th>
				<td>${d.fee }</td>
			</tr>
			<tr>
				<th class="table-success">주체</th>
				<td>${d.company }</td>
			</tr>
			<tr>
				<th class="table-success">정보</th>
				<td>${d.info}</td>
			</tr>
			<tr>
				<th class="table-success">이미지</th>
				<td><img src="upload/${b.image}" style="width: 400px; height: 200px;"></td>
			</tr>
		</table>
		<%-- <input type="hidden" name="${b.bp_no }"> --%>
		<div class="button">
			<button type="submit" class="btn btn-primary" onclick="location.href='updateBP.do?no=${b.bp_no}'">수정</button>
			<button type="submit" class="btn btn-primary" onclick="location.href='deleteBP.do?no=${b.bp_no}'">삭제</button>
			<%-- <td><a href="updateBP.do?no=${b.bp_no }"><input type="button" value="수정" class="btn btn-primary"></a></td> --%>
		</div>
	</div>
</body>
</html>
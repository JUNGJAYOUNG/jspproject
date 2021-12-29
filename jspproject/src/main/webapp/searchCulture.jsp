<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function pro(){
	var search = $("#search").val();
	location.href='searchCulture.do?search='+search;
	
}
</script>
<style type="text/css">
	#title{
		font-size: 32px;
		font-style: bold;
	}

	.card{
		position: relative;
		float: left;
		width: 30%;
		height: 250px;
		margin: 20px;
		border: 1px solid #ofofof33;
		text-align: center;
	}
	#paging{
		padding-top: 100px;
		padding-left: 45%;
	}
#paging{
	clear: both;
}
#container{
	width: 80%;
}

</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div id="container">
<hr>
	<% String search = (String)request.getAttribute("search"); %>

	<img src="image/cul.png" width="100%" >
	<hr>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="culture.do">문화배프</a></li>
	  <li class="breadcrumb-item active">검색결과</li>
	</ol>
	<br>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="culture.do">문화배프</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
        </li>
        <li class="nav-item">
          <a class="nav-link" href="cultureFavor.do">인기순</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="cultureName.do">이름순</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"  role="button" aria-haspopup="true" aria-expanded="false">영업일</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="cultureHolyday.do?holiday=월">월요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=화">화요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=수">수요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=목">목요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=금">금요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=토">토요일</a>
            <a class="dropdown-item" href="cultureHolyday.do?holiday=일">일요일</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">지역순</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="cultureLoc.do?loc=서울">서울</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=부산">부산</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=대구">대구</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=인천">인천</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=광주">광주</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=대전">대전</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=울산">울산</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=강원">강원</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=경기">경기</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=경남">경남</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=경북">경북</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=전남">전남</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=전북">전북</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=제주">제주</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=충남">충남</a>
            <a class="dropdown-item" href="cultureLoc.do?loc=충북">충북</a>
          </div>
        </li>
      </ul>
		<div class="input-group mb-3" style="width:20%;  float:right; position: relative;">
			      <input type="text" class="form-control" name="search" id="search">
			      <button class="btn btn-primary" type="submit" id="button-addon2" onclick="pro();">검색</button>
		</div>
    </div>
  </div>
</nav>
<br>
	<h2>${search }의 검색결과 (총 ${cnt }건)</h2>
	<br>
	<div>
		<c:forEach var="c" items="${culList }">

			<a href="cultureDetail.do?no=${c.bp_no }">
			<div class="card mb-3" >
			  <h3 class="card-header">${c.bp_name }</h3>
					
			  <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="30%" height="250" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
			    <rect width="100%" height="100%" fill="#868e96"></rect>
			    <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
			    <img src="upload/${c.image }" style="width: 100%; height: 250px;">
			  </svg>
			</div>
			</a>
		</c:forEach>
	</div>
	<br>
	<br>
	<br>
	
	
	<div id="paging" >
			<c:forEach var="i" begin="1" end="${totalPage }">
				<a href="searchCulture.do?search=<%=search %>&pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
	</div>		

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
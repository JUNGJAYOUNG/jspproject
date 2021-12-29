<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cardBox{
	display: inline-block;
}
 .card1 {
        height: 400px;
        width: 350px;
        border-radius: 15px;
        display: inline-block;
        margin-top: 15%;
        margin-left: 10%;
        margin-bottom: 15%;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 
        rgba(0, 0, 0, 0.19);
        overflow: hidden;
        /* float: left; */        
        }
</style>
</head>
<body>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">관리자페이지</li>
	</ol>
	<div class="cardBox">
		<div class="card1"><a></a>
			<div class="image1"><img src="image/logo.png" width="100%" height="80%"></div>
			<p>관리자페이지</p>
		</div>
		<div class="card2"><a></a>
			<div class="image2"><img></div>
			<p></p>
		</div>
		<div class="card3"><a></a>
			<div class="image3"><img></div>
			<p></p>
		</div>	
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
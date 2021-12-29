<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">

<style type="text/css">
footer{
	margin:0 auto;
	padding:0 auto;
	width: 100%;
	height: 200px;
	display: inline-block;
	position: relative;
	bottom: 0;
}
.footer_box{
	background-image: url("../image/bg.png");
	background-size: 100% 90%;
	margin: 0 auto;
}
.footer_logo{
	margin: 0 auto;
	position: relative;
	float: left; 
	width: 40%;
}
.footer_addr{
	margin: 0 auto;
	position: relative;
	float: left; 
	width: 50%
}
.footer_addr li{
	padding-top:30px;
	position:relative;
	list-style:none;
	font-size: 30px;
}
.footer_copyright{
	margin-top:0;
	clear:both;
	text-align: center;
    width: 100%;
}
.footer_copyright p{
	background-color: #20c997;
}
</style>
</head>
<body>
<footer>
	<div class="footer_box" style='background: url("image/bg.png") no-repeat center; 	background-size: 100% 100%;'>
		<div class="footer_logo">
		<img src="image/logo.png" width="200px;" height="200px;">
		</div>
		<div class="footer_addr">
			<ul>
				<li>서울특별시 마포구 서교동 쌍용교육센터</li>
				<li>010-1234-1234</li>
			</ul>
		</div>
		<div class="footer_copyright">
		<p>Copyright &copy; 2021 배프랑놀자 
	                            | All right reserved</p>
		</div>
	</div>
</footer>
	
</body>
</html>
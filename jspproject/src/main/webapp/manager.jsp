<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cardBox{
    display:flex;
	width: 100%;
	justify-content: center;
}
 .card:first-child{margin-left:0}
 .card {
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
<jsp:include page="menu.jsp"/>

	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">관리자페이지</li>
	</ol>

	<div class="cardBox">
		<div class="card"><a></a>
			<div class="image1">
			<a href="listMember.jsp"><img src="image/member_manage.png" width="100%"></a>
			</div>
			
		</div>
		<div class="card"><a></a>
			<div class="image2">
			<a href="manageBusiness.jsp"><img src="image/bp_manage.png" width="100%"></a>
			</div>
		</div>
		<div class="card"><a></a>
			<div class="image3">
			<a href="ansQna.jsp"><img src="image/qna_manage.png" width="100%"></a>
			</div>
		</div>	
	</div>
<jsp:include page="footer.jsp"/>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/menu2.css">
</head>
<body>
<%
	String member_id=null;
	if(session.getAttribute("member_id")!= null){
		member_id=(String)session.getAttribute("member_id");
	}
%>


<nav class="navbar">
		<div class="navbar_logo"> 
			<a href="#"><img id="logo" src="image/logo.png"></a>
		</div>

		<ul class="navbar_menu">
			<li><a href="#">관광배프</a></li>
			<li><a href="#">문화배프</a></li>
			<li><a href="#">사업장등록</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="#">문의사항</a></li>
		</ul>
			<%
                   	if(member_id==null){
            %>
		<ul class="navbar_link">
                    <a class="nav_btn" href="#">
                        <button class="btn btn-success btn-lg">로그인</button>
                    </a>
                    <a class="nav-btn" href="#">
                       <button class="btn btn-success btn-lg">회원가입</button>
                    </a>
  			<%
			}else{
			%>
					 <a class="nav_btn" href="#">
                        <button class="btn btn-success btn-lg">로그아웃</button>
                    </a>
                    <a class="nav-btn" href="#">
                       <button class="btn btn-success btn-lg">마이페이지</button>
                    </a>
			<% 
			}
			%>
			
		</ul>
	</nav>
</body>
</html>
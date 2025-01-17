<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
nav{
	background : url("../image/bg.png") no-repeat center;	
	background-size: 100% 100%;
	overflow:visible;
	width:100%;
	height: 200px;
}

body{
	margin: 0;
}
a{
	text-decoration: none;
	color: black;
}
.navbar {
	display: flex;
	justify-content: space-between;
	padding: 8px 12px;
}

.navbar_logo {
	display: flex;
}
#logo{
	padding-left : 8px;
	margin:0px;
	width: 180px;
	height: 180px;
}
.navbar_menu ul {
	display: flex;
	align-items: center;
	padding-left: 0;
}

.navbar_menu li{
	padding: 8px 12px;
	float:left;
	list-style: none;
	font-size: 30px;
}
.navbar_menu a{
	text-decoration: none;
}
.navbar_link{
	padding-right: 5px;
	display: flex;
}

.navbar_link a{
	padding: 5px;
}

@media screen and (max-width:768px){
	nav{
	background : url("../image/bg.png") no-repeat center;	
	background-size: 100% 100%;
	overflow:visible;
	width:90%;
	height: 500px;
	}
	body{
		margin: 0;
	}
	a{
		text-decoration: none;
		color: black;
	}
	.navbar {
		display: flex;
		/*justify-content: space-between;*/
		padding: 8px 12px;
		width: 100%;
	}
	.navbar_logo {
		display: flex;
	}
	#logo{
		padding-left : 8px;
		margin:0px;
		width: 180px;
		height: 180px;
	}
	.navbar_menu ul {
		display: flex;
		align-items: center;
		padding-left: 0;
	}
	.navbar_menu li{
		/*padding: 8px 12px;*/
		float:left;
		list-style: none;
		font-size: 30px;
	}
	.navbar_menu a{
		text-decoration: none;
	}
	.navbar_link{
		/*padding-right: 5px;*/
		display: flex;
	}
	
	.navbar_link a{
		padding: 5px;
	}
	
	body{
		width: 100%;
	}
	.navbar{
		flex-direction: column;
		/*align-items: flex-start;*/
		padding: 8px 24px;
		width: 100%;
		height: 350px;
	}
	.navbar_menu{
		flex-direction: column;
		/*align-items: center;*/
		/*width: 100%;*/
		width: 50%;	
	}
	.navbar_menu{		
		align-items: center;	
		width: 60%;
	}
	.navbar_link{
		display: flex;
		padding-left:0; 	
	}
	.navbar_logo{
		display: flex;
		padding-left:0; 
		width: 20%;
		height: 100%;
	}
	.navbar_menu li{
		width: 100%;
		text-align: center;
		list-style: none;
		padding: 2px;
	}
		
	.navbar_link li{
		width: 100%;
		text-align: center;
		list-style: none;
		padding: 2px;
	}

}

</style>
</head>
<body bgcolor="pink">
<%
	String member_id=null;
	if(session.getAttribute("member_id")!= null){
		member_id=(String)session.getAttribute("member_id");
	}
%>



<nav class="navbar" style='background: url("image/bg.png") no-repeat center; 	background-size: 100% 100%;'>
		<div class="navbar_logo"> 
			<a href="main.do"><img id="logo" src="image/logo.png"></a>
		</div>

		<ul class="navbar_menu">
			<li><a href="tour.do">관광배프</a></li>
			<li><a href="culture.do">문화배프</a></li>
			<li><a href="addBusinessPlace.do">사업장등록</a></li>
			<li><a href="noticeMember.do">공지사항</a></li>
			<li><a href="addQna.do">문의사항</a></li>
		</ul>
		
			<ul class="navbar_link">
			<% if(member_id==null){%>
                    <a class="nav_btn" href="login.do">
                        <button class="btn btn-success btn-lg">로그인</button>
                    </a>
                    <a class="nav-btn" href="join.do">
                       <button class="btn btn-success btn-lg">회원가입</button>
                    </a>
  			<%
			}else{
			%>
				 <a class="nav_btn" href="logout.do">
                       <button class="btn btn-success btn-lg">로그아웃</button>
                   </a>
                 <a class="nav-btn" href="mypage.do">
                      <button class="btn btn-success btn-lg">마이페이지</button>
                 </a>
			<% 
			}
			%>
		</ul>
	</nav>
</body>
</html>
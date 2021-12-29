<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-color: #78c2ad;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin: auto;
  margin-top: 120px;
  max-width: 330px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
.container {
	width: 50%;
}

.btn-primary {
  color: #fff;
  background-color: #78c2ad;
  border-color: #78c2ad;
}

.btn-primary:hover {
  color: #fff;
  background-color: #66a593;
  border-color: #609b8a;
}
.btn-check:focus + .btn-primary, .btn-primary:focus {
  color: #fff;
  background-color: #66a593;
  border-color: #609b8a;
  box-shadow: 0 0 0 0.25rem rgba(140, 203, 185, 0.5);
} 
.btn-secondary {
  color: #fff;
  background-color: #f3969a;
  border-color: #f3969a;
}

.btn-secondary:hover {
  color: #fff;
  background-color: #cf8083;
  border-color: #c2787b;
}

.btn-check:focus + .btn-secondary, .btn-secondary:focus {
  color: #fff;
  background-color: #cf8083;
  border-color: #c2787b;
  box-shadow: 0 0 0 0.25rem rgba(245, 166, 169, 0.5);
}
.text-secondary {
  color: #f3969a;
}

</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">로그인</li>
	</ol>
<div id="login">
	<div class="container">
	 <div id="login-row" class="row justify-content-center align-items-center">
      	<div id="login-column" class="col-md-6">
        	<div id="login-box" class="col-md-12">
				<form id="login-form" action="loginOK.do" method="post" onsubmit="return msg();">
				<h3 class="text-center text-info">로그인</h3>
				<div style="margin-left:30px;">
				<div class="form-group">
					<label>아이디</label><br>
					<input type="text" name="member_id" id="member_id">
				</div>
				<div class="form-group">
					<label>비밀번호</label><br>
					<input type="password" name="member_pwd" id="member_pwd">
				</div>
				</div>
				<input type="submit" value="로그인" class="btn btn-primary" style="margin-left:100px;">
				</form>
				<div style="margin-left:30px;">
					<a href="findID.do" class="text-secondary">아이디찾기</a>
					<a href="findPwd.do" class="text-secondary">비밀번호찾기</a>
					<a href="join.do" class="text-secondary">회원가입</a>
				</div>
			  </div>
			</div>
		</div>				
	</div>
</div>
<br><br><br>
<jsp:include page="footer.jsp"/>
</body>
</html>
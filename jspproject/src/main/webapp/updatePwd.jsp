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
  margin-top: 120px;
  max-width: 600px;
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
<script type="text/javascript">
function validation(){
 // ================ PASSWORD 유효성검사 ===============//
    var RegExp = /^[a-zA-Z0-9]{5,12}$/; //id와 pwassword 유효성 검사 정규식
    var objPwd = document.getElementById("member_pwd");   //비밀번호
    var objPwd2 = document.getElementById("pwdcheck");    //비밀번호확인
   
    if(!RegExp.test(objPwd.value)){ //패스워드 유효성검사
        alert("비밀번호는 5~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
        return false;
    }
    if(objPwd2.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return false;
    }
}
</script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">비밀번호 수정</li>
	</ol>
<div id="login">
	<a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;비밀번호 수정
	<div class="container">
	 <div id="login-row" class="row justify-content-center align-items-center">
      	<div id="login-column" class="col-md-6">
        	<div id="login-box" class="col-md-12">
        	<form id="login-form" action="updatePwd.do" method="post" onsubmit="return validation();">
				<h3 class="text-center text-info">비밀번호 수정</h3>
				<div style="margin-left:30px;">
					<input type="hidden" name="member_no" id="member_no" value="${member_no}"><br>
					<label>새로운 비밀번호</label><br>
					<input type="password" name="member_pwd" id="member_pwd"><br>
					<label>새로운 비밀번호 확인</label><br>
					<input type="password" name="pwdcheck" id="pwdcheck"><br>
				</div>
				<div class="btn-group" style="margin-top:15px;margin-left:100px;">
					<input type="submit" value="수정" class="btn btn-primary">
				</div>
			</form>
			</div>
			</div>
			</div>
		</div>			
	</div>			
	<jsp:include page="footer.jsp"/>
</body>
</html>

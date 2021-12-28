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
  height: 400px;
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
//생년월일 selectbox 함수
$(document).ready(function(){ 
	var now = new Date(); 
	var year = now.getFullYear(); 
	var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
	var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate()); 
	for(var i = 1900 ; i <= year ; i++) { //년도 selectbox만들기 
		$('#year').append('<option value="' + i + '">' + i + '</option>'); }  
	for(var i=1; i <= 12; i++) { //월별 selectbox 만들기
		var mm = i > 9 ? i : "0"+i ; 
		$('#month').append('<option value="' + mm + '">' + mm + '</option>'); } 
	for(var i=1; i <= 31; i++) { 	// 일별 selectbox 만들기 
		var dd = i > 9 ? i : "0"+i ; 
		$('#day').append('<option value="' + dd + '">' + dd+ '</option>'); } 
	$("#year > option[value="+year+"]").attr("selected", "true"); 
	$("#month > option[value="+mon+"]").attr("selected", "true"); 
	$("#day > option[value="+day+"]").attr("selected", "true"); })
</script>
<title>Insert title here</title>
</head>
<body>
<div id="login">
	<a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;비밀번호 찾기
	<div class="container">
	 <div id="login-row" class="row justify-content-center align-items-center">
      	<div id="login-column" class="col-md-6">
        	<div id="login-box" class="col-md-12">
				<form action="findPwdOK.do" method="post">
				<h3 class="text-center text-info" style="margin-top:10px;">비밀번호 찾기</h3>
				<div style="margin-left:50px;">
					<label>아이디</label><br>
					<input type="text" name="member_id" id="member_id" style="width:200px;"><br>
					<label>이름</label><br>
					<input type="text" name="member_name" id="member_name" style="width:200px;"><br>
					<label>전화번호</label><br>
					<select name="tel1" id="tel1">
							<option value="010">010</option>
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="051">051</option>
					</select>-
					<input type="text" name="tel2" id="tel2" maxlength="4" style="width:60px;">-
					<input type="text" name="tel3" id="tel3" maxlength="4" style="width:60px;"><br>
					<label>생년월일</label><br>
						<select name="yy" id="year"></select>년
						<select name="mm" id="month"></select>월
						<select name="dd" id="day"></select>일<br>
				</div>
				<div class="btn-group" style="margin-top:30px;margin-left:120px;">
					<input type="submit" value="찾기" class="btn btn-primary">
				</div>
				</form>
			</div>
			</div>
			</div>
		</div>			
	</div>			
</body>
</html>
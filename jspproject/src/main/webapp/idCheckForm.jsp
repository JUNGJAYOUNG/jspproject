<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

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

}
</style>
<script type="text/javascript"> 
function validation(f){ 
	var RegExp = /^[a-zA-Z0-9]{5,12}$/; //id 유효성 검사 정규식 
	var objId = document.getElementById("member_id");     //아이디
	if(!RegExp.test(objId.value)){ //아이디 유효성검사
        alert("아이디는 5~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
        return false;
    }
	return true; 
} 
</script>
</head>
<body>
<div class="container"> 
	<form method="post" action="idCheckPro.jsp" onsubmit="return validation(this)"> 
	<div class="id" style="display:block;margin-right:auto;margin-left:auto;margin-top:100px;">
		<label>아이디</label>
		<input type="text" name="member_id" id="member_id" maxlength="10" autofocus class="form-control" style="display:inline-block;width:50%;">
		<input type="submit" value="중복확인" class="btn btn-primary" style="display:inline-block;"> 
	</div>
	</form>
</div>
</body>
</html>
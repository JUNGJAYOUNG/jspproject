<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
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
<h2>회원가입</h2>
<h3>*는 필수입력 사항입니다.</h3>
<form action="joinOK.do" method="post">
	*아이디<br>
	<input type="text" name="member_id"><br>
	*비밀번호<br>
	<input type="password" name="member_pwd"><br>
	*비밀번호 확인<br>
	<input type="password" name="pwdcheck"><br>
	*이름<br>
	<input type="text" name="member_name"><br>
	생년월일<br>
	<select name="yy" id="year"></select>년
	<select name="mm" id="month"></select>월
	<select name="dd" id="day"></select>일<br>
	성별<br>
	<input type="radio" name="gender" value="남" checked>남	
	<input type="radio" name="gender" value="여">여<br>
	*전화번호<br>
	<select name="tel1">
			<option value="010">010</option>
			<option value="02">02</option>
			<option value="031">031</option>
			<option value="051">051</option>
	</select>-
	<input type="text" name="tel2" maxlength="4">-
	<input type="text" name="tel3" maxlength="4"><br>
	주소<br>
	<input type="text" name="addr"><br>
	이메일<br>
	<input type="text" name="email"><br>	<!-- 유효성검사로 형식 지정할 예정 -->
	취미<br>
	<input type="text" name="hobby"><br>
	<input type="reset" value="취소">
	<input type="submit" value="가입">
</form>
</body>
</html>
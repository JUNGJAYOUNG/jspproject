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
	
//아이디 중복확인 함수
function idCheck(){
	//새창 만들기
	window.open("idCheckForm.jsp", "idwin", "width=600, height=350");
}

function validation(){
    var RegExp = /^[a-zA-Z0-9]{5,12}$/; //id와 pwassword 유효성 검사 정규식
    var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일 유효성검사
    var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식
    
    var objId = document.getElementById("member_id");     //아이디
    var objPwd = document.getElementById("member_pwd");   //비밀번호
    var objPwd2 = document.getElementById("pwdcheck");    //비밀번호확인
    var objName = document.getElementById("member_name"); //이름
    var objTel1 = document.getElementById("tel1");		  //전화번호
    var objTel2 = document.getElementById("tel2");
    var objTel3 = document.getElementById("tel3");
    var objEmail = document.getElementById("email");	  //이메일
    
    // =============== 필수입력사항 입력여부 검사 ================== //
    
    if(objId.value==''){
        alert("아이디를 입력해주세요.");
        return false;
    }
    if(objPwd.value==''){
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    if(objPwd2.value==''){
    	alert("비밀번호 확인을 입력해주세요");
    	return false;
    }
    if(objName.value ==''){
        alert("이름을 입력해주세요.");
        return false;
    }
    if(objTel1.value =='' || objTel2.value =='' || objTel3.value =='' ){
    	alert("전화번호를 입력해주세요.");
    	return false;
    }
    /*
    // ================ ID 유효성검사 ================ //
     
    if(!RegExp.test(objId.value)){ //아이디 유효성검사
        alert("ID는 5~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
        return false;
    }
    */
    
    // ================ PASSWORD 유효성검사 ===============//
    
    if(!RegExp.test(objPwd.value)){ //패스워드 유효성검사
        alert("비밀번호는 5~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
        return false;
    }
    if(objPwd.value==objId.value){ //패스워드와 ID가 동일한지 검사
        alert("비밀번호는 아이디와 동일하면 안됩니다.");
        return false;
    }
    if(objPwd2.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
        alert("비밀번호가 틀립니다. 다시 확인하여 입력해주세요.");
        return false;
    }
    
    // ================ email 유효성검사 ================ //
    
    if(!e_RegExp.test(objEmail.value)){ //이메일 유효성 검사
        alert("올바른 이메일 형식이 아닙니다.");
        return false;
    }
    
    // ================ 이름 유효성검사 ================ //        
   
    if(!n_RegExp.test(objName.value)){
        alert("특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");
        return false;
    }
     
}
</script>	
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<h3>*는 필수입력 사항입니다.</h3>
<form action="joinOK.do" name="regForm" method="post" onsubmit="return validation();">
	*아이디<br>
	<input type="text" name="member_id" id="member_id" size="15" readonly>
	<button type="button" value="중복확인" onclick="idCheck()">중복확인</button>
	<br>
	*비밀번호<br>
	<input type="password" name="member_pwd" id="member_pwd"><br>
	*비밀번호 확인<br>
	<input type="password" name="pwdcheck" id="pwdcheck"><br>
	*이름<br>
	<input type="text" name="member_name" id="member_name"><br>
	생년월일<br>
	<select name="yy" id="year"></select>년
	<select name="mm" id="month"></select>월
	<select name="dd" id="day"></select>일<br>
	성별<br>
	<input type="radio" name="gender" id="gender" value="남" checked>남	
	<input type="radio" name="gender" id="gender" value="여" >여<br>
	*전화번호<br>
	<select name="tel1" id="tel1">
			<option value="010">010</option>
			<option value="02">02</option>
			<option value="031">031</option>
			<option value="051">051</option>
	</select>-
	<input type="text" name="tel2" id="tel2" maxlength="4">-
	<input type="text" name="tel3" id="tel3" maxlength="4"><br>
	주소<br>
	<input type="text" name="addr" id="addr"><br>
	이메일<br>
	<input type="text" name="email" id="email"><br>
	취미<br>
	<input type="text" name="hobby" id="hobby"><br>
	<input type="reset" value="취소">
	<input type="submit" value="가입">
</form>
</body>
</html>
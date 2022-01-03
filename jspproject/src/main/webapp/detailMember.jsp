<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.container {
 
  background-color : #78c2ad;
}
.form-check .form-check-input {
  float: left;
  margin-left: -1.5em;
}

.form-check-input {
  width: 1em;
  height: 1em;
  margin-top: 0.25em;
  vertical-align: top;
  background-color: #fff;
  background-repeat: no-repeat;
  background-position: center;
  background-size: contain;
  border: 1px solid rgba(0, 0, 0, 0.25);
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  -webkit-print-color-adjust: exact;
  color-adjust: exact;
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
h2 {
  padding-top: 30px;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
<% request.setCharacterEncoding("utf-8"); %>

<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="manager.do">관리자페이지</a></li>
	  <li class="breadcrumb-item"><a href="listMember.do">회원관리</a></li>
	  <li class="breadcrumb-item active">상세정보</li>
</ol>
<hr>
<div class="container">
	<h2 class="text-center">회원상세정보</h2>
	<div class="col-lg-12 well">
	<div class="row">
		<form action="joinOK.do" id="login" name="regForm" method="post" onsubmit="return validation();">
		<div class="col-sm-12">
			<div class="row">
			<div class="col-sm-6 form-group">
				<label>아이디</label><br>
				<input type="text" name="member_id" value ="${m.member_id}" id="member_id" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>이름</label>
				<input type="text" name="member_name" value ="${m.member_name}" id="member_name" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>생년월일</label><br>
				<input type="text" name="birth" value ="${m.birth}" id="birth" class="form-control" readonly>
				</div>
			<div class="col-sm-6 form-group">
				<label>성별</label>
				<input type="text" name="gender" value ="${m.gender}" id="gender" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>전화번호</label><br>
				<input type="text" name="tel" id="tel" value="${m.member_tel}" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>주소</label>
				<input type="text" name="addr" id="addr" value="${m.addr}" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>이메일</label>
				<input type="text" name="email" id="email" value="${m.email}" class="form-control" readonly>
			</div>
			<div class="col-sm-6 form-group">
				<label>취미</label>
				<input type="text" name="hobby" id="hobby" value="${m.hobby}" class="form-control" readonly>
			</div>
	</div>
	</div>
</form>
</div>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
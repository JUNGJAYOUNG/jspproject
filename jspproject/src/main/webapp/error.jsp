<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	body{
		background-color: #9AD3BC;
		background-image: url("image/error.jpg");
		background-repeat: no-repeat;
	}
</style>
</head>
<body>
	<div class="alert alert-dismissible alert-primary">
	  <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	  <strong>오류 발생!</strong> <a href="#" class="alert-link">${msg }</a>
	</div>
</html>
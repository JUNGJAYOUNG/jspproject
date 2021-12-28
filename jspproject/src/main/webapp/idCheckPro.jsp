<%@page import="com.sist.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	margin-top: 20px;
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
</style>
<script type="text/javascript">
	function apply(member_id){
		opener.document.regForm.member_id.value=member_id;
		window.close();
	}
</script>
</head>
<body>
<div class="container">
	<h3 class="text-center">아이디 중복 확인 결과</h3> 
	<% //1) 사용가능한 아이디일 경우, 아이디 입력 폼에 넣기 위함 
		String member_id=request.getParameter("member_id"); 
		MemberDAO dao = new MemberDAO();
		int cnt=dao.duplicateID(member_id); 
		out.println("입력 ID : <strong>" + member_id + "</stong>"); 
		if(cnt==0){ 	
			out.println("<div class='alert alert-success'><p>사용 가능한 아이디입니다.</p></div>");
			out.println("<button type='button' class='btn btn-primary' style='position:absolute;right:50px;'><a href='javascript:apply(\"" + member_id + "\")' style='color:white'>적용</a></button>"); 	
		}else{ 
			out.println("<div class='alert alert-danger'><p>해당 아이디는 사용하실 수 없습니다.</p></div>"); 
			out.println("<button type='button' class='btn btn-secondary' style='position:absolute;right:50px;'><a href='javascript:history.back()'  style='color:white'>다시검색</a></button>");
		}//if end
	%>
</div>
</body>
</html>
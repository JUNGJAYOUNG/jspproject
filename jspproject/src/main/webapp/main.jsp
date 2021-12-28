<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String re = (String)session.getAttribute("member");
	
		if(re==null)
		{
			response.sendRedirect("login.jsp");
		}
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");

	%>
	<h2><%=name %> 회원님 환영합니다.</h2>
	<hr>
	<a href="listMember.do">1번째 서비스</a><br>
</body>
</html>
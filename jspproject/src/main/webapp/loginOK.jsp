<%@page import="com.sist.dao.MemberDAO"%>
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
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	MemberDAO dao = new MemberDAO();
	if(dao.login(id,pwd)){
		session.setAttribute("member", "yes");
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>
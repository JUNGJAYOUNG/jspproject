<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  
<title>Insert title here</title>
<style type="text/css">

.pagination {
  display: -ms-flexbox;
  display: flex;
  padding-left: 0;
  list-style: none;
}

.page-link {
  position: relative;
  display: block;
  color: #fff;
  text-decoration: none;
  background-color: #78c2ad;
  border: 1px solid #78c2ad;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

@media (prefers-reduced-motion: reduce) {
  .page-link {
    transition: none;
  }
}

.page-link:hover {
  z-index: 2;
  color: #fff;
  background-color: #f3969a;
  border-color: #f3969a;
}

.page-link:focus {
  z-index: 3;
  color: #609b8a;
  background-color: #f7f7f9;
  outline: 0;
  box-shadow: 0 0 0 0.25rem rgba(120, 194, 173, 0.25);
}

.page-item:not(:first-child) .page-link {
  margin-left: -1px;
}

.page-item.active .page-link {
  z-index: 3;
  color: #fff;
  background-color: #f3969a;
  border-color: #f3969a;
}

.page-item.disabled .page-link {
  color: #fff;
  pointer-events: none;
  background-color: #cce8e0;
  border-color: #cce8e0;
}

.page-link {
  padding: 0.375rem 0.75rem;
}

.page-item:first-child .page-link {
  border-top-left-radius: 0.4rem;
  border-bottom-left-radius: 0.4rem;
}

.page-item:last-child .page-link {
  border-top-right-radius: 0.4rem;
  border-bottom-right-radius: 0.4rem;
}

.pagination-lg .page-link {
  padding: 0.75rem 1.5rem;
  font-size: 1.25rem;
}

.pagination-lg .page-item:first-child .page-link {
  border-top-left-radius: 0.6rem;
  border-bottom-left-radius: 0.6rem;
}

.pagination-lg .page-item:last-child .page-link {
  border-top-right-radius: 0.6rem;
  border-bottom-right-radius: 0.6rem;
}

.pagination-sm .page-link {
  padding: 0.25rem 0.5rem;
  font-size: 0.875rem;
}

.pagination-sm .page-item:first-child .page-link {
  border-top-left-radius: 0.3rem;
  border-bottom-left-radius: 0.3rem;
}

.pagination-sm .page-item:last-child .page-link {
  border-top-right-radius: 0.3rem;
  border-bottom-right-radius: 0.3rem;
}

.container {
	width: 100%;
}

.table {
	width: 500px;
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

th {
  text-align: center;
}

tr > td{
  text-align: center;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="manager.do">관리자페이지</a></li>
	  <li class="breadcrumb-item active">회원관리</li>
	</ol>
<hr>
<div class="container">
<div class="table table-hover">
<table border="1" style="width:1000px;">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">아이디</th>
		<th scope="col">이름</th>
		<th scope="col">상세정보</th>	
	</tr>
	
	<c:forEach var="m" items="${list}">
		<tr>
			<td>${m.member_no}</td>
			<td>${m.member_id}</td>
			<td>${m.member_name}</td>
			<td><button type="button" onclick="location.href='detailMember.do?member_no=${m.member_no}'" class="btn btn-primary">열람</button></td>
		</tr>
	</c:forEach>
</table>
</div>	
<br>
<div>
	<ul class="pagination justify-content-center">
		<li class="page-item disabled">
      		<a class="page-link" href="#">&laquo;</a>
    	</li>
		<c:forEach var="i" begin="1" end="${totalPage}">
			<li class="page-item"><a class="page-link" href="listMember.do?pageNum=${i}">${i}</a></li>		
		</c:forEach>
		<li class="page-item">
      		<a class="page-link" href="#">&raquo;</a>
   		</li>
	</ul>
</div>	
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	#title{
		font-size: 32px;
		font-style: bold;
	}

	.card{
		position: relative;
		float: left;
		width: 30%;
		height: 250px;
		margin: 20px;
		border: 1px solid #ofofof33;
		text-align: center;
	}

#paging{
	clear: both;
}

</style>
<script type="text/javascript">
	function clearText(thefield) {
		if (thefield.defaultValue==thefield.value)
	        thefield.value = ""
	}
	var cat1_num = new Array(1,2,3,4);
	 var cat1_name = new Array('지역','인기순','이름순','영업일');

	 var cat2_num = new Array();
	 var cat2_name = new Array();
	 
	 cat2_num[1] = new Array(5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
	 cat2_name[1] = new Array('서울','부산','대구','인천','광주','대전','울산','강원','경기','경남','경북','전남','전북','제주','충남','충북');

	 cat2_num[2] = new Array(21,22);
	 cat2_name[2] = new Array('인기높은순','인기낮은순');

	 cat2_num[3] = new Array(23,24);
	 cat2_name[3] = new Array('오름차순','내림차순');

	 cat2_num[4] = new Array(25,26,27,28,29,30,31);
	 cat2_name[4] = new Array('월','화','수','목','금','토','일');
	 
	function cat1_change(key,sel){
	 if(key == '') return;
	 var name = cat2_name[key];
	 var val = cat2_num[key];

	 for(i=sel.length-1; i>=0; i--)
	  sel.options[i] = null;
	 sel.options[0] = new Option('-선택-','', '', 'true');
	 for(i=0; i<name.length; i++){
	  sel.options[i+1] = new Option(name[i],val[i]);
	 }
	}
	function handleOnInput(el, maxlength) {
		  if(el.value.length > maxlength)  {
		    el.value 
		      = el.value.substr(0, maxlength);
		  }
		}

</script>

	
</head>
<body>
<div>
	<hr>
	<img src="image/cul.png" width="100%" >
	<hr>
	<nav style="position: relative; ">

		<a href="#"><img src="image/home.png"></a>&nbsp;&nbsp;>&nbsp;&nbsp;문화배프
		<div class="input-group mb-3" style="width:20%;  float:right; position: relative;">
	      <input type="text" class="form-control" >
	      <button class="btn btn-primary" type="button" id="button-addon2">Button</button>
	    </div>
		<select name="h_area2" onChange="cat2_change(this.value)" class="form-select" style="width:100px; float:right; position: relative;" >
			<option>-선택-</option>
		</select>
		<select name="h_area1" onChange="cat1_change(this.value,h_area2)" class="h_area1, form-select" style="width:100px; float:right; position: relative;">
			<option>-선택-</option>
			<option value='1'>지역</option>
			<option value='2'>인기순</option>
			<option value='3'>이름순</option>
			<option value='4'>영업일</option>
		</select>
		

	</nav>
	<br>
	<div>
		<c:forEach var="c" items="${culList }">
			<div class="card">
				<a href="cultureDetail.do?no=${c.bp_no }"><img src="upload/${c.image }" style="width: 100%; height: 250px;"></a>
				<div class="words">
					<h2>${c.bp_name }</h2>
				</div>
			</div>	
		</c:forEach>
	</div>
	<br>
	<br>
	<br>
	
	
</div>
<div id="paging" >
			<c:forEach var="i" begin="1" end="${totalPage }">
				<a href="culture.do?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
			</c:forEach>
	</div>		
</body>
</html>
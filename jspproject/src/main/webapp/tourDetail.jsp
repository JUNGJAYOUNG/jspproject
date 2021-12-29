<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">


</script>
<style type="text/css">
	#back{
		
		background-image: url("upload/${b.image}");
		background-repeat: no-repeat;
		opacity: 0.5;
		color: black;
		margin: 20px;
		background-size: cover;
		clear: both;
		height: 300px;
	}
	#info{
		width: 300px;
		
		background-color: white;
		opacity: 0.8; 
		height: 300px;
	
	}
	#container{
		width: 80%;
	}

	p{
		margin-bottom: 0px;
		opacity: 1;
		
	}
	.bottom{
		padding-top: 150px;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<div style="position: relative;">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item"><a href="tour.do">관광배프</a></li>
	  <li class="breadcrumb-item active">관광상세</li>
	</ol>
</div>

<div id="container">
		<div style="float: right; margin-bottom: 10px;"><button onclick="location.href='clickTourFavor.do?no=${b.bp_no}'" ><img src="image/${image }" ></button>${cntfavor }</div> 
		<div id="back">
			<div id="info">
				<span style="font-weight: bold; font-size: 32px; ">${b.bp_name }</span>
				<span class="badge bg-warning">${btname }</span>
				<p style="font-size: 24px;">${d.info }</p>
				<p>도메인 : ${b.domain }</p>

				<p id="loc" >${b.loc }</p>

				<p>전화번호 : ${b.bp_tel }</p>
			</div>
		</div>
		<br>
		<div>
			<h1>상세정보</h1>
			<table class="table table-hover">
				<tr>
					<th class="table-success">휴무일</th>
					<td>${d.holiday }</td>
				</tr>
				<tr>
					<th class="table-success">영업시간</th>
					<td>${d.time }</td>
				</tr>
				<!-- 
				<tr>
					<th class="table-success">운영기간</th>
					<td>${d.start_date }~${d.end_date }</td>
				</tr>	
				 -->
				<tr>	
					<th class="table-success">입장료</th>
					<td>${d.fee }</td>
				</tr>
				<!-- 
				<tr>
					<th class="table-success">주체</th>	
					<td>${d.company }</td>
				</tr>
				 -->
			</table>
		
		</div>
		<div>
			<h1>시설지원</h1>
			<table style="width: 90%">
				<tr>
					<td><img src="image/${babycar }"></td>	
					<td><img src="image/${babyinner }"></td>	
					<td><img src="image/${dotinfo }"></td>	
				</tr>
				<tr>
					<td><img src="image/${ele }"></td>	
					<td><img src="image/${parking }"></td>	
					<td><img src="image/${round }"></td>	
				</tr>
				<tr>
					<td><img src="image/${speaking }"></td>	
					<td><img src="image/${toliet }"></td>	
					<td><img src="image/${wheel }"></td>	
				</tr>
			
			</table>
			
		</div>
		
		
		<div>
			<p style="margin-top:-12px">
			    <em class="link">
			        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
			            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
			        </a>
			    </em>
			</p>
			<div id="map" style="width:100%;height:350px;"></div>
			
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=594ce3422824dfcb5845fde8156d5268&libraries=services"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  
			
			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			
			var loc = document.getElementById('loc').innerHTML;
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(loc, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">위치</div>'
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});    
			</script>
		
		</div>
		<br>
		<br>
		
		<h3>한줄후기</h3>
		<form action="insertReviewOK.do?no=${b.bp_no}" method="post">
			<div class="input-group mb-3" style="position: relative;">
		     	<input type="text" class="form-control" placeholder="후기를 입력해주세요" name="comments" maxlength="20">
		     	<button class="btn btn-primary" type="submit" id="button-addon2">등록</button>
		 	</div>
		 </form>
		 <table class="table table-hover">
		 	<tr>
		 		<td>작성자</td>
		 		<td>내용</td>
		 		<td>작성일</td>
		 		
		 	</tr>
		 	<c:forEach var="review" items="${r }">
					<tr>
						<td>${review.member_name}</td>
						<td>${review.comments }</td>
						<td>${review.review_date }</td>
					</tr>
			</c:forEach>
		 </table>
	
		 <br>
		 <div class="page">
				<c:forEach var="i" begin="1" end="${totalPage }">
				<a href="tourDetail.do?no=${b.bp_no }&pageNUM=${i }">${i }</a>&nbsp;&nbsp;
				</c:forEach>
			</div>
		 <br>
		 <br>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
	*{
		/*position: absolute;*/
	}
	#title{
		font-size: 32px;
		font-style: bold;
	}
	#name{
		width:50px;
	}
	input[type="number"]::-webkit-outer-spin-button,
	input[type="number"]::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	    margin: 0;

	}
	#fee{
		text-align:right;
	}
	th{
	}
	td{
		background-color: white;
	}
	.container{
		width: 70%;
	}
	button{
		float: right;
	}
	#default{
		font-size: 9px;
		text-align: right;
		color: red;
	}
</style>
<script type="text/javascript">
	function clearText(thefield) {
		if (thefield.defaultValue==thefield.value)
	        thefield.value = ""
	}
	var cat1_num = new Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
	 var cat1_name = new Array('서울','부산','대구','인천','광주','대전','울산','강원','경기','경남','경북','전남','전북','제주','충남','충북');

	 var cat2_num = new Array();
	 var cat2_name = new Array();

	 cat2_num[1] = new Array(17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41);
	 cat2_name[1] = new Array('강남구','강동구','강북구','강서구','관악구','광진구','구로구','금천구','노원구','도봉구','동대문구','동작구','마포구','서대문구','서초구','성동구','성북구','송파구','양천구','영등포구','용산구','은평구','종로구','중구','중랑구');

	 cat2_num[2] = new Array(42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57);
	 cat2_name[2] = new Array('강서구','금정구','남구','동구','동래구','부산진구','북구','사상구','사하구','서구','수영구','연제구','영도구','중구','해운대구','기장군');

	 cat2_num[3] = new Array(58,59,60,61,62,63,64,65);
	 cat2_name[3] = new Array('남구','달서구','동구','북구','서구','수성구','중구','달성군');

	 cat2_num[4] = new Array(66,67,68,69,70,71,72,73,74,75);
	 cat2_name[4] = new Array('계양구','남구','남동구','동구','부평구','서구','연수구','중구','강화군','옹진군');

	 cat2_num[5] = new Array(76,77,78,79,80);
	 cat2_name[5] = new Array('광산구','남구','동구','북구','서구');

	 cat2_num[6] = new Array(81,82,83,84,85);
	 cat2_name[6] = new Array('대덕구','동구','서구','유성구','중구');

	 cat2_num[7] = new Array(86,87,88,89,90);
	 cat2_name[7] = new Array('남구','동구','북구','중구','울주군');

	 cat2_num[8] = new Array(91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108);
	 cat2_name[8] = new Array('강릉시','동해시','삼척시','속초시','원주시','춘천시','태백시','고성군','양구군','양양군','영월군','인제군','정선군','철원군','평창군','홍천군','화천군','횡성군');

	 cat2_num[9] = new Array(109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148);
	 cat2_name[9] = new Array('고양시 덕양구','고양시 일산구','과천시','광명시','광주시','구리시','군포시','김포시','남양주시','동두천시','부천시 소사구','부천시 오정구','부천시 원미구','성남시 분당구','성남시 수정구','성남시 중원구','수원시 권선구','수원시 장안구','수원시 팔달구','시흥시','안산시 단원구','안산시 상록구','안성시','안양시 동안구','안양시 만안구','오산시','용인시','의왕시','의정부시','이천시','파주시','평택시','하남시','화성시','가평군','양주군','양평군','여주군','연천군','포천군');

	 cat2_num[10] = new Array(149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168);
	 cat2_name[10] = new Array('거제시','김해시','마산시','밀양시','사천시','양산시','진주시','진해시','창원시','통영시','거창군','고성군','남해군','산청군','의령군','창녕군','하동군','함안군','함양군','합천군');

	 cat2_num[11] = new Array(169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192);
	 cat2_name[11] = new Array('경산시','경주시','구미시','김천시','문경시','상주시','안동시','영주시','영천시','포항시 남구','포항시 북구','고령군','군위군','봉화군','성주군','영덕군','영양군','예천군','울릉군','울진군','의성군','청도군','청송군','칠곡군');

	 cat2_num[12] = new Array(193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214);
	 cat2_name[12] = new Array('광양시','나주시','목포시','순천시','여수시','강진군','고흥군','곡성군','구례군','담양군','무안군','보성군','신안군','영광군','영암군','완도군','장성군','장흥군','진도군','함평군','해남군','화순군');

	 cat2_num[13] = new Array(215,216,217,218,219,220,221,222,223,224,225,226,227,228,229);
	 cat2_name[13] = new Array('군산시','김제시','남원시','익산시','전주시 덕진구','전주시 완산구','정읍시','고창군','무주군','부안군','순창군','완주군','임실군','장수군','진안군');

	 cat2_num[14] = new Array(230,231,232,233);
	 cat2_name[14] = new Array('서귀포시','제주시','남제주군','북제주군');

	 cat2_num[15] = new Array(234,235,236,237,238,239,240,241,242,243,244,245,246,247,248);
	 cat2_name[15] = new Array('공주시','논산시','보령시','서산시','아산시','천안시','금산군','당진군','부여군','서천군','연기군','예산군','청양군','태안군','홍성군');

	 cat2_num[16] = new Array(249,250,251,252,253,254,255,256,257,258,259,260);
	 cat2_name[16] = new Array('제천시','청주시 상당구','청주시 흥덕구','충주시','괴산군','단양군','보은군','영동군','옥천군','음성군','진천군','청원군');

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
	//폰넘버 4자리수까지
	function handleOnInput(el, maxlength) {
		  if(el.value.length > maxlength)  {
		    el.value 
		      = el.value.substr(0, maxlength);
		  }
		}
	function checkBP() {
		var regExpH_area=/^[0-9]*$/;
		var regExpH_type=/^[0-9]*$/;
		var btn= document.BP.business_type_name.value;
		var bp_name= document.BP.bp_name.value;
		var h_area1= document.BP.h_area1.value;
		var h_area2= document.BP.h_area2.value;
		var address= document.BP.address.value;
		
		if(!regExpH_type.test(btn)){
			alert("사업장 종류는 필수로 선택해야 합니다");
			document.BF.business_type_name.focus();
			return false;
		}
		if(bp_name.length <1){
			alert("사업장명은 필수로 입력해야 합니다");
			document.BF.bp_name.focus();
			return false;
		}
		if(!regExpH_area.test(h_area1) || !regExpH_area.test(h_area2)){
			alert("지역을 필수로 선택해야합니다.");
			document.BP.h_area1.focus();
			return false;
		}
		if(address<1){
			alert("주소는 필수로 입력해야 합니다");
			document.BF.address.select();
			return false;
		}

		document.BP.submit();
	}

      

</script>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="main.do"><img src="image/home.png"></a></li>
	  <li class="breadcrumb-item active">배프사업장 수정</li>
	</ol>
	<br>
	<br>
	
	<div class="container">
		<div id="default">*는 필수 입력사항입니다.</div>
		<form action="updateBPOK.do" method="post" enctype="multipart/form-data" name="BP">
			<input type="hidden" name="no" value="${b.bp_no }">
			<input type="hidden" name="fname" value="${b.image }">
			<table class="table table-hover">
				<tr class="table-active">
					<th scope="row" ">사업장 종류*</th>
					<td>
						<select name="business_type_name" class="form-select">
					    	<option>-선택-</option>
					    	<option value="1">관광-유적지</option>
					    	<option value="2">관광-박물관</option>
					    	<option value="3">관광-미술관</option>
					    	<option value="4">관광-기타</option>
					    	<option value="5">문화-연극</option>
					    	<option value="6">문화-영화</option>
					    	<option value="7">문화-뮤지컬</option>
					    	<option value="8">문화-전시</option>
					    	<option value="9">문화-축제</option>
					    	<option value="10">문화-기타</option>
						</select>
					</td>
				</tr>
				<tr class="table-active">
					<th scope="row">사업장 이름*</th>
					<td><input text="text" name="bp_name"  class="form-control" id="inputDefault" value="${b.bp_name }"></td>
				</tr>
				<tr class="table-active">
					<th scope="row">지역*</th>
					<td>
						<select name="h_area1" onChange="cat1_change(this.value,h_area2)" class="h_area1, form-select" style="width:100px;">
						  <option>-선택-</option>
						  <option value='1'>서울</option>
						  <option value='2'>부산</option>
						  <option value='3'>대구</option>
						  <option value='4'>인천</option>
						  <option value='5'>광주</option>
						  <option value='6'>대전</option>
						  <option value='7'>울산</option>
						  <option value='8'>강원</option>
						  <option value='9'>경기</option>
						  <option value='10'>경남</option>
						  <option value='11'>경북</option>
						  <option value='12' >전남</option>
						  <option value='13'>전북</option>
						  <option value='14'>제주</option>
						  <option value='15'>충남</option>
						  <option value='16'>충북</option>
						</select>
						<select name="h_area2" onChange="cat2_change(this.value)" class="form-select" style="width:100px;">
						  <option>-선택-</option>
						</select>
						<p><input type="text" name="address" class="form-control" id="floatingInput" placeholder="(도로명 주소)">
					</td>
				</tr>
				<tr class="table-active">
					<th>URL</th>
					<td><input type="url" name="url" placeholder="URL을 입력해주세요" class="form-control" id="inputDefault" value="${b.domain}"></td>
				</tr  class="table-active">
				<tr  class="table-active">
					<th>사업장 전화번호</th>
					<td><input type="number"  name="tel1" oninput='handleOnInput(this, 4)'  style="width:100px;" value="${tel1 }">-<input type="number" name="tel2" oninput='handleOnInput(this, 4)' style="width:100px;" velue="${tel2 }">-<input type="number" name="tel3" oninput='handleOnInput(this, 4)' style="width:100px;" velue="${tel3 }"></td>
				
				</tr>
				<tr  class="table-active">
					<th>시설지원</th>
					<td>
						<input type="checkbox" name="sup" value="휠체어" class="form-check-input" id="flexCheckChecked">휠체어&nbsp;
						<input type="checkbox" name="sup" value="유아차" class="form-check-input" id="flexCheckChecked">유아차&nbsp;
						<input type="checkbox" name="sup" value="장애인전용화장실" class="form-check-input" id="flexCheckChecked">장애인 전용 화장실&nbsp;
						<input type="checkbox" name="sup" value="가족화장실" class="form-check-input" id="flexCheckChecked">장애인 전용 화장실&nbsp;
						<input type="checkbox" name="sup" value="주차장" class="form-check-input" id="flexCheckChecked">주차장&nbsp;
						<br>
						<input type="checkbox" name="sup" value="음성안내기" class="form-check-input" id="flexCheckChecked">음성안내기&nbsp;
						<input type="checkbox" name="sup" value="점자안내판" class="form-check-input" id="flexCheckChecked">점자안내판&nbsp;
						<input type="checkbox" name="sup" value="기저귀" class="form-check-input" id="flexCheckChecked">기저귀 교환대 및 수유실&nbsp;
						<input type="checkbox" name="sup" value="승강기" class="form-check-input" id="flexCheckChecked">승강기&nbsp;
						<input type="checkbox" name="sup" value="경사로" class="form-check-input" id="flexCheckChecked">경사로&nbsp;
					</td>
				</tr>
				<tr  class="table-active">
					<th>휴무일</th>
					<td>
						<input type="checkbox" name="holiday" value="월요일" class="form-check-input" id="flexCheckChecked">월요일
						<input type="checkbox" name="holiday" value="화요일" class="form-check-input" id="flexCheckChecked">화요일
						<input type="checkbox" name="holiday" value="수요일" class="form-check-input" id="flexCheckChecked">수요일
						<input type="checkbox" name="holiday" value="목요일" class="form-check-input" id="flexCheckChecked">목요일
						<input type="checkbox" name="holiday" value="금요일" class="form-check-input" id="flexCheckChecked">금요일
						<input type="checkbox" name="holiday" value="토요일" class="form-check-input" id="flexCheckChecked">토요일
						<input type="checkbox" name="holiday" value="일요일" class="form-check-input" id="flexCheckChecked">일요일
					</td>
				</tr>
				<tr  class="table-active">
					<th>영업시간</th>
					<td><input type="time"  name="start_time">~<input type="time"  name="end_time"></td>
				</tr>
				<tr  class="table-active">
					<th>기간</th>
					<td><input type="date"  name="start_date">~<input type="date"  name="end_date"></td>
				</tr>
				<tr  class="table-active">
					<th>입장료</th>
					<td><input type="number" name="fee"  id="fee">원</td>
				</tr>				
				<tr  class="table-active">
					<th>주체</th>
					<td><input class="form-control" id="inputDefault" type="text" name="company" value="${d.company }"></td>
				</tr>
				<tr  class="table-active">
					<th>정보</th>
					<td><textarea rows="5" cols="60" name="info" class="form-control" id="exampleTextarea"  style="resize: none;" >${d.info }</textarea></td>
				</tr>
				
				<tr  class="table-active">
					<th>이미지 등록</th>
					<td>${b.image }<input type="file" class="form-control" name="uploadFile"></td>
				</tr>
				
			</table>
			
			<input type="button" value="수정" style="float: right;" class="btn btn-primary" onclick="checkBP()">
			
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
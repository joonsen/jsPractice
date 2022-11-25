<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_input_form.jsp</title>
<link rel="stylesheet" href="./css_teacher/student_teacher.css"/>
<script src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
<script defer src='js/student.js'></script>
</head>

<body>
<div id='std_input'>
	<h2>학생 정보 입력</h2>
	<form name='frm_input'	method='post'	action='서버페이지'
	onsubmit='return chkForm(this)'>
		<span>*아이디</span>
		<input type='search' value='a001' name='id'size='10' 
			   autocomplete='off' maxLength='20'	required
			   placeholder = '영어로 시작하고 영숫자만'
				pattern="^[a-zA-z]\w{3,19}$"/>
		<br/>
		<span>*성 명</span>
		<input type='search' value='홍길동' name='mName' size='20' maxLegnth='20' required/>
		<br/>
		<span>*성별</span>
		<label><input type='radio' name='gender' value='m' checked='checked'>남자</label>
		<label><input type='radio' name='gender' value='f'>여자</label>
		<br/>
		<span>*암호</span>
		<input type='password' value='1234' name='pwd' size='15' maxLength='15' required/>
		<br/>
		<span>*암호 확인</span>
		<input type='password' value='1234' name='pwd2' size='15' maxLength='15' required/>
		<br/>
		<span>*연락처</span>
		<input type='search' value='010-1234-5678' name='phone' size='20' 
			   autocomplete='off' maxLength='13' required
			   placeholder='[xx\xxx]-[xxx\xxxx]-xxxx'
			   pattern="^\d{2,3}-\d{3,4}-\d{4}$"/>
		<br/>
		<span>*우편번호</span>
		<input type='text' name='zipcode' size='5' required readOnly/>
		<input type='button' name='findZip' value='우편번호 검색'/>
		<br/>
		<span>*주소</span>
		<input type='text' name='address' size='40' required/>
		<br/>
		<span>상세주소</span>
		<input type='text' value='1234' name='address2' size='30'/>
		<br/>
		<span>이메일</span>
		<input type='email' value='asdf@nate.com' name='email' value='abc@abc.kr'/>
				
		<br/>
		<span></span>
		<div class='btnZone'>
			<span></span>
			<input type='submit' value='저장' name='btnSave'/>
			<input type='button' value='취소' name='btnCancel'/>
		</div>
		
		<input type='text' name='findStr' value='${pageVo.findStr }'/>
		<input type='text' name='nowPage' value='${pageVo.nowPage }'/>
	
	</form>

</div>
<Script>
/* let frm = document.frm_input;

// 우편번호 검색기능 추가
frm.findZip.onclick = function(){
	new daum.Postcode({
		oncomplete : function(data){
			frm.address.value = data.address;
			frm.zipcode.value = data.zonecode;
		}
	}).open();
}
 */
//아이디: 영숫자만 입력 html에 pattern으로 추가 완료

//연락처: 연락처 패턴에 맞게 입력 pattern으로 추가 완료

// 이메일: 이메일 패턴에 맞게 입력 input type을 email로 하면 완료

// 암호와 암호확인의 값이 동일한지 체크

function chkForm(frm){
	let b=true;
	if(frm.pwd.value != frm.pwd2.value){
		b=false;
		alert("비밀번호 불일치")
	}
}


</Script>
</body>


</html>












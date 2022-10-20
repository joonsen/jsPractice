<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_input_form_teacher.jsp</title>
<link rel="stylesheet" href="../css_teacher/student_teacher.css"/>
</head>
<body>
<div id='std_input'>
	<h2>학생 정보 입력</h2>
	<form name='frm_input'	method='post'	action='서버페이지'>
		<span>*아이디</span>
		<input type='search' name='id'size='10' 
			   autocomplete='off' maxLength='20'	required/>
		<br/>
		<span>*성 명</span>
		<input type='search' name='mName' size='20' maxLegnth='20' required/>
		<br/>
		<span>*성별</span>
		<label><input type='radio' name='gender' value='m' checked='checked'>남자</label>
		<label><input type='radio' name='gender' value='f'>여자</label>
		<br/>
		<span>*암호</span>
		<input type='password' name='pwd' size='15' maxLength='15' required/>
		<br/>
		<span>*암호 확인</span>
		<input type='password' name='pwd2' size='15' maxLength='15' required/>
		<br/>
		<span>*연락처</span>
		<input type='search' name='phone' size='12' 
			   autocomplete='off' maxLength='13' required/>
		<br/>
		<span>*우편번호</span>
		<input type='text' name='zipcode' size='5' required readOnly/>
		<input type='button' value='우편번호 검색'/>
		<br/>
		<span>*주소</span>
		<input type='text' name='address' size='40' required/>
		<br/>
		<span>상세주소</span>
		<input type='text' name='address2' size='30'/>
		<br/>
		<span>이메일</span>
		<input type='search' name='email'/>
				
		<br/>
		<span></span>
		<div class='btnZone'>
			<span></span>
			<input type='submit' value='저장'>
			<input type='button' value='취소'/>
		</div>
	
	</form>

</div>

</body>


</html>
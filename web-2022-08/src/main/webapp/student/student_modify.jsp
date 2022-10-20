<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_modify.jsp</title>
<link rel="stylesheet" href="../css/student.css">
</head>
<body>
<h2>학생정보 수정</h2>
<form name='frm' method='post' action='register.do'>
	<span>아이디</span>
	<input type = 'text' name='id' maxlength='10'/>
	<br/>
	<span>성명</span>
	<input type='text' name='name1' maxlength='10'/>
	<br/>
	<span>성별</span>
	<label><input type='radio' name='gender' value='m'/>남자</label>
	<label><input type='radio' name='gender' value='f'/>여자</label>
	<br/>
	<span>암호</span>
	<input type='password' name='pwd' size='10' maxlength='10'/>
	</br>
	<span>암호 확인</span>
	<input type='password' name='pwd' size='10' maxlength='10'/>
	</br>
	<span>연락처</span>
	<input type='text' name='call' size='10' maxlenghth='12'/>
	</br>
	<span>우편번호</span>
	<input type='text' name='add_num'/>
	<input type='button' name='add_search' value='우편번호 검색'/>
	<br/>
	<span>주소</span>
	<input type='text' name='address'/>
	<br/>
	<span>상세 주소</span>
	<input type='text' name='add_spec'/>
	<br/>
	<span>이메일</span>
	<input type='text' name='email'/>
	<br/>
	<input type='button' value='수정'/>
	<input type='button' value='삭제'/>
	<input type='button' value='취소'/>
</form>




</body>
</html>
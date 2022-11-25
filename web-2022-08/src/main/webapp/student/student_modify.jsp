<%@page import="student.StudentDao"%>
<%@page import="student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_modify.jsp</title>
<link rel="stylesheet" href="./css/student.css">
<script defer src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
<script defer src='js/student.js'></script>
</head>
<body>

<div id='student' class='student_input'>
<h2>학생정보 수정</h2>
<form name='frm_student' method='post' action='register.do'>
	<span class='id'>아이디</span>
	<input type = 'text' name='id' value='${vo.id }'maxlength='10'/>
	<br/>
	<span class='name'>성명</span>
	<input type='text' name='name1' maxlength='10' value='${vo.name }' readOnly/>
	<br/>
	<span>성별</span>
	<label>
		<input type='radio' name='gender' value='m' 
			${ (vo.gender eq 'm')? 'checked':'' }/>	남자
	</label>
	
	<label>
		<input type='radio' name='gender' value='f' 
			${ (vo.gender eq 'f')? 'checked':'' }/>	여자
	</label>
	
	<br/>
	<span>암호</span>
	<input type='password' name='pwd' size='10' maxlength='10'/>
	</br>
	<span>암호 확인</span>
	<input type='password' name='pwd' size='10' maxlength='10'/>
	</br>
	<span>연락처</span>
	<input type='text' name='phone' value='${vo.phone }' size='10' maxlenghth='12'/>
	</br>
	<span>우편번호</span>
	<input type='text' name='zipcode' value='${vo.zipcode }'/>
	<input type='button' name='add_search' value='우편번호 검색'/>
	<br/>
	<span>주소</span>
	<input type='text' name='address' value='${vo.address }'/>
	<br/>
	<span>상세 주소</span>
	<input type='text' name='add_spec' value='${vo.address2 }'/>
	<br/>
	<span>이메일</span>
	<input type='text' name='email' value='${vo.email }'/>
	<br/>
	<div class='btnZone'>
		<span></span>
		<input type='button' value='수정' id='btnModify'/>
		<input type='button' value='삭제' id='btnDelete'/>
		<input type='button' value='목록' id='btnSelect'/>
	</div>
	<input type='text' name='findStr' value='${pageVo.findStr }'/>
	<input type='text' name='nowPage' value='${pageVo.nowPage }'/>
</form>

<script>
/* checkGender('${vo.gender}');
function checkGender(g){
	var frm = document.frm_student;
	if(g=='m') frm.gender[0].checked=true;
	else frm.gender[1].checked=true;
}
 */

let frm1 = document.frm_student;
frm1.add_search.onclick = function(){
   new daum.Postcode({
      oncomplete : function(data){
         frm1.address.value = data.address;
         frm1.zipcode.value = data.zonecode;
      }
   }).open(); //daum에서 제공해주는 우편번호 api를 여는 코드
}
</script>


</div>
</body>
</html>
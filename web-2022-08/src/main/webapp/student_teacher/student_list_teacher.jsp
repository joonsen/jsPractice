<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
<link rel="stylesheet" href="./css_teacher/student_teacher.css"/>
<script defer src='js/student.jsp'></script>
</head>

<body>
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<div id='std_list'>
	<h2>학생정보 조회</h2>
	<form name='frm_search' method='post'>
		<input type='button' value='입력' name='btnInsert'/>
		<input type='search' name='findStr' value="<%=pageVo.getFindStr() %>" />
		<input type='button' value='조회' name='btnSelect'/>
		<input type='text' name='nowPage' value ="<%=pageVo.getNowPage() %>"/>
	</form>
	<ul>
		<a href=student_input_form_teacher.jsp>
		<li class='title'> <!--  타이틀 -->
			<span class='no'>No</span>
			<span class='id'>아이디</span>
			<span class='name'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
			<span class='address'>주소</span>
			<span class='email'>이메일</span>
			<span class='zipcode'>우편번호</span>
		</li>
		<% for(int i=1; i<=10 ; i++ ){ %>
		<li class='item'>
			<span class='no'><%=i %></span>
			<span class='id'>a001</span>
			<span class='name'>홍길자</span>
			<span class='gender'>남자</span>
			<span class='phone'>010-1111-1234</span>
			<span class='address'>제주시 제주마을</span>
			<span class='email'>hipwg@naver.com</span>
			<span class='zipcode'>01234</span>
		</li>
		<%} %>
		<li class='btn_page'><!-- page 이동 버튼 -->
			<input type='button' value='처음'/>
			<input type='button' value='이전'/>
			
			<input type='button' value='1'/>
			<input type='button' value='2'/>
			<input type='button' value='3'/>
			<input type='button' value='4'/>
			
			<input type='button' value='다음'/>
			<input type='button' value='맨끝'/>
		</li>
		</a>
		
	</ul>
</div>
</body>
</html>
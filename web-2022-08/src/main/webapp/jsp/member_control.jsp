<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_control.html</title>
<link rel='stylesheet' href='./css/member_control.css'>
<script defer src='./js/member_control2.js'></script>
</head>
<body>
<main>
<div id='main'>
	<div class='main_title'>
	회원정보 CRUD
	</div>
	<form name='frm' enctype='multipart/form-data' method='post' action='memberUpload.do'>
		<div class='photo'>
			<img src='../images/b.png' class='img' name='img' onclick='preview()'/>
			<input type='file' name='photo'/>
		</div>
		<div class='data'>
			<span>아이디</span>
			<input type='text' name='id' value='a001'/><br/>
			<span>성명</span>
			<input type='text' name='name' value='hong'/><br/>
			<span>성별</span>
			<label><input type='radio' name='gender' value='m'>남자</label>
			<label><input type='radio' name='gender' value='f'>여자</label>
			<br/>
			<span>연락처</span>
			<input type='text' name='phone' value='010-1111-1234'/>
			<hr/>
			<span></span>
			<input type='button' value='CREATE' name='btnAppend' onclick='add(this.form)'/>
			<input type='button' value='UPDATE' name='btnUpdate' onclick='update(this.form)'/>
			<input type='button' value='DELETE' name='btnDelete' onclick='deleteFunc(this.form)'/>
		</div>
	</form>
	<div id='list'>
		<div id='title'>
			<span class='id'>아이디</span>
			<span class='name'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
		</div>
		<div id='items'>
			<div class = 'item'>
				<span class = 'id'>a001</span>
				<span class = 'name'>홍길동</span>
				<span class = 'gender'>m</span>
				<span class='phone'>010-1111-1234</span>
			</div>
		</div>
	</div>
</div>

</main>
</body>
</html>
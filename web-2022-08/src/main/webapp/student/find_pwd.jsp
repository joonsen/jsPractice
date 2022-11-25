<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/find_pwd.jsp</title>
</head>
<body>
<h2>암호찾기</h2>
<div class='frm_login'>
	<form name='frm_pwd' method='post' action='./findpwd.do'>
		<label>아이디</label>
		<input type='text' name='id'/><br/>
		<input type='text' name='receiver'/><br/>
		<input type='button' value='확인' name='btnCheck'/>
	</form>
	<div class='msg'></div>
</div>
<script>
var frm = document.frm_pwd;
frm.btnCheck.onclick = function(){
	var xhr = new XMLHttpRequest();
	
	var param = `?id=\${frm.id.value}&receiver=\${frm.receiver.value}`;
	xhr.open('post', './findpwd.do')
	
	xhr.send(frm);
	xhr.onreadystatechange = function() {
		var data = xhr.responseText;
		var msg = document.querySelector('.msg');
		msg.style.padding = '20px';
		msg.style.border = "2px solid #88f";
		msg.innerHTML = data;
	}
}
</script>
</body>
</html>











<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_list.jsp</title>
<link rel="stylesheet"  href="../css/student.css">
</head>
<body>
<h2>학생정보 조회</h2>
<div>
	<input type='button' value="입력">
	<input type='search'>
	<form action="http://192.168.0.32:8888/web-2022-08/student/student_input_form.jsp"><a>
		<input type='submit' value="조회">
	</a></form>
</div>
<table>
	<tr class="first">
		<th>No</th>
		<th>아이디</th>
		<th>성명</th>
		<th>성별</th>
		<th>연락처</th>
		<th>주소</th>
		<th>이메일</th>
		<th>우편번호</th>
	</tr>
	<tr>
		<th>1</th>
		<th>a002</th>
		<th>kim2</th>
		<th>f</th>
		<th>6666</th>
		<th>서울 강남구 봉은사로 111길5</th>
		<th>6666</th>
		<th>06083</th>
	</tr>
	<tr>
		<th>2</th>
		<th>a003</th>
		<th>hong gil</th>
		<th>m</th>
		<th>9999</th>
		<th>서울 금천구 시흥대로88가길 3</th>
		<th>6666</th>
		<th>08620</th>
	</tr>
	<tr>
		<th>3</th>
		<th>b001</th>
		<th>kim</th>
		<th>m</th>
		<th>010-1111-2222</th>
		<th>서울 강남구 강남대로 112길 12</th>
		<th>kim@jobtc.kr</th>
		<th>06120</th>
	</tr>
	<tr>
		<th>4</th>
		<th>a010</th>
		<th>김씨</th>
		<th>m</th>
		<th>123456</th>
		<th>서울 강남구 봉은사로55길 17</th>
		<th>kim@jobtc.kr</th>
		<th>06097</th>
	</tr>
	<tr>
		<th>5</th>
		<th>a001</th>
		<th>나야나</th>
		<th>m</th>
		<th>123-1234</th>
		<th>서울 강북구 삼양로123길 6-8</th>
		<th>na@jobtc.kr</th>
		<th>01029</th>
	</tr>

</table>
</body>
</html>
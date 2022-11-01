<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/static_sub.jsp</title>
</head>
<body>
<div>
	<%
	String vv="아이쿠~충돌";//v로 지정하면 duplicate variable -> error;;
	String f = "static_sub.jsp";
	%>
	<font color='red' size='7'>
	본 내용은 외부에 정의된 페이지 내용입니다.
	</font>
</div>
</body>
</html>
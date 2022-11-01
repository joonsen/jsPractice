<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/logout.jsp</title>
</head>
<body>
<%
	session.setAttribute("mId", null);	//특정값만 지우기
//	session.invalidate();	//세션에 저장된 값을 모두 지워... 거의 안씀
	response.sendRedirect("login.jsp"); //sendRedirect 아래 코드는 작동하지 않아요
%>
</body>
</html>
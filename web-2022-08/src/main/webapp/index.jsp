<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel='stylesheet' 
	type='text/css'
	href='./css/index.css'>
</head>
<body>

<%
String inc = "temp.html";
if(request.getParameter("inc") != null){
	inc = request.getParameter("inc");
}

String sessionId = (String)session.getAttribute("sessionId");

%>
<main>
	<div class='login'>
		<%if (sessionId == null) { %>
			<a href='index.jsp?inc=member/login.jsp'>로그인</a>
		<% }else { %>
			[<%=sessionId %> 님 방가]
			<a href='member/logout.jsp'>로그아웃</a>
		<% } %>
		
	</div>
	<header>
		<div class="logo">
			<img src="images/d.png" alt="logo" width="120px" height="120px"/>
		</div>
		<nav>
			<a href='student.do'>학생관리</a>
			<a href='index.jsp?inc=javascript/score_crud_tch.html'>성적관리</a>
			<a href='index.jsp?inc=member/member_control.jsp'>회원관리</a>
			<a href='#'>제품관리</a>
			<a href='#'>생산관리</a>
			<a href='#'>방명록</a>
			<a href='#'>게시판</a>
		</nav>
	</header>
	<div class='content'>
		<jsp:include page="<%=inc %>"/>
	</div>
	<footer>
		大韓民國
	</footer>
</main>
</body>
</html>
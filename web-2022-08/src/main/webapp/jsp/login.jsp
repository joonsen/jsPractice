<%@page import="jdbc.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/login.jsp</title>
</head>
<body>
<%
	if(request.getMethod().equals("POST")){		//method가 post type으로 요청했니
		String mId= request.getParameter("mId");
		Login l = new Login();
		boolean b = l.login(mId, "");
		if(b){
			session.setAttribute("mId", mId);
			session.setMaxInactiveInterval(5);	//session이 살아있는 시간이 약 5초
		}else{
			out.print("<script>alert('꺼지셈~')</script>");
		}
		session.setAttribute("mId", mId);
	}

	String sessionId = (String)session.getAttribute("mId");		//session이 있을때 로그인前창. 없을때 로그인後창.
	//jsp를 할땐 library가 web-inf 폴더의 lib에 있어야한다
%>
<form name='frm_login' method='post' action='log.jsp'> 
	<%if(sessionId==null){ %>
		<span>아이디</span>
		<input type='text' name='mId' value='hong'autocomplete="off"/>
		<span>암호</span>
		<input type='password' name='pwd' value='1111'/>
		<input type='button' value='로그인' name='btnLogin'/> 
	<%} else{ %>
		<span><%=sessionId %>님 방가</span>
		<input type='button' value='로그아웃' name='btnLogout'/>
	<%} %>
</form>

<script>
var frm = document.frm_login;
if(frm.btnLogin != null){
	frm.btnLogin.onclick = function(){
		frm.action = "login.jsp";	//자기가 자기자신을 부름
		frm.submit();
	}
}
if(frm.btnLogout != null){
	frm.btnLogout.onclick = function(){
		frm.action = "logout.jsp";
		frm.submit();
	}
}
</script>

</body>
</html>














<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%// 이안쪽 영역은 java 영역
//application 영역에 저장된 접속자수를 가져옴.
Object o = application.getAttribute("cnt");	//getAttribute의 return type이 object. object type은 java로 만든 모든 class를 저장할 수 있다.
int cnt = 1;
if(o==null){// 방문자가 없는 경우	-- 내가 최초 방문자다
	cnt=1;
}else{
	cnt = (Integer)o;
	cnt++;
}
application.setAttribute("cnt",cnt);

%>
<b>오늘 방문자수: <%=cnt %></b>
</body>
</html>
















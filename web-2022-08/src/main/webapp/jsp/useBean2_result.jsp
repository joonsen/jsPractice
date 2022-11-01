<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>useBean 사용안함</h3>
<%
	String id = request.getParameter("id");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int tot = kor + eng + mat;
	double avg = tot/3.0; 
%>
<ul>
	<li>ID : <%=id %></li>
	<li>KOR : <%=kor %></li>
	<li>ENG : <%=eng %></li>
	<li>MAT : <%=mat %></li>
	<li>TOT : <%=tot %></li>
	<li>AVG : <%=avg %></li>
</ul>

<h3>useBean 사용함</h3>
<jsp:useBean id='vo' class="jsp.BeanTestVo2"/>
<jsp:setProperty property="*" name="vo"/><%//*는 form tag에서 전달받은걸 한번에~ %>
<ul>
	<li>ID : <%=vo.getId() %></li>
	<li>KOR : <%=vo.getKor() %></li>
	<li>ENG : <%=vo.getEng() %></li>
	<li>MAT : <%=vo.getMat() %></li>
	<li>TOT : <%=vo.getTot() %></li>
	<li>AVG : <%=vo.getAvg() %></li>
</ul>


</body>
</html>












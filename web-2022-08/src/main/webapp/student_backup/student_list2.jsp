<%@page import="student.StudentDao"%>
<%@page import="student.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
<link rel="stylesheet" href="./css_teacher/student_teacher.css"/>
<script defer src='js/student.js'></script>
</head>

<body>
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>
<%
StudentDao dao = new StudentDao();
List<StudentVo> list = dao.select(pageVo);

%>



<div id='std_list'>
	<h2>학생정보 조회</h2>
	<form name='frm_search' method='post'>
		<input type='button' value='입력' name='btnInsert'/>
		<input type='search' name='findStr' size='40' value="<%=pageVo.getFindStr() %>" />
		<input type='button' value='조회' name='btnSelect'/>
		<input type='text' name='nowPage' value ="<%=pageVo.getNowPage() %>"/>
		<%//<input type='text' name='id'/> %>
	</form>
	<ul>
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
		<% for(int i=0; i<list.size(); i++ ){
			StudentVo v = list.get(i);	
		%>
		<li class='item' onclick="view('<%=v.getId()%>')"><%//통상적 관례 - 밖은 큰따옴표. 안은 작은 따옴표 %>
			<span class='no'><%=i+1 %></span>
			<span class='id'><%=v.getId() %></span>
			<span class='name'><%=v.getName() %></span>
			<span class='gender'><%=v.getGender() %></span>
			<span class='phone'><%=v.getPhone() %></span>
			<span class='address'><%=v.getAddress() %></span>
			<span class='email'><%=v.getEmail() %></span>
			<span class='zipcode'><%=v.getZipcode() %></span>
		</li>
		<%} %>
		<li class='btn_page'><!-- page 이동 버튼 -->
			<%if(pageVo.getStartPage()>1) { 	//startPage가 1보다클때만 처음, 이전 버튼을 넣어라%>
			<input type='button' value='처음' onclick='movePage(1)'/>		<!--  얘누르면 나오는 페이지가 1이 돼야함. -->
			<input type='button' value='이전' onclick='movePage(<%=pageVo.getStartPage()-1%>)'/>
			<%} %>
			
			<%for(int i=pageVo.getStartPage(); i<=pageVo.getEndPage();i++){ %>
				<input type='button' value='<%=i%>' onclick='movePage(<%=i %>)'/>
			<%} %>
			
			<%if(pageVo.getTotPage()>pageVo.getEndPage()){ 	//이 코드들이 왜 추가가 돼야하는지 이해 필수%>
				<input type='button' value='다음' onclick='movePage(<%=pageVo.getEndPage()+1 %>)'/>
				<input type='button' value='맨끝' onclick='movePage(<%=pageVo.getTotPage()%>)'/>
			<%} %>
		</li>
		
		
	</ul>
</div>
</body>
</html>
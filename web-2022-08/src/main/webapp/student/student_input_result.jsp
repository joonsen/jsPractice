<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/student_input_result</title>
<script defer src='js/student.js'></script>
</head>
<body>
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="studentVo" class="student.StudentVo"/>   <!-- 아이디에서부터~이메일까지 인풋폼에서 입력한정보를 담을 형태가필요함->StudentVo.java의 입력형태를 사용 -->
<jsp:setProperty property="*" name="studentVo"/>

<form name='frm' method='post'>
   <input type='text' name='findStr' value = '<%=pageVo.getFindStr() %>'>
   <input type='text' name='nowPage' value = '<%=pageVo.getNowPage() %>'>
</form>

<%
StudentDao dao = new StudentDao();
boolean b = dao.insert(studentVo);   


if( !b ){ %>
   <script>
      alert('자료 저장중 오류 발생');   
   </script>
<%} %>


<script>
   var frm = document.frm;
   frm.action="index.jsp?inc=student/student_list.jsp";
   frm.submit();
</script>

   





</body>
</html>



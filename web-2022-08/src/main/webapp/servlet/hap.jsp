<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet/hap.jsp</title>
</head>
<body>
<%
double d = 0, e = 0;
double su1=0, su2=0;
if(request.getAttribute("hap") != null){
	d = (double)(request.getAttribute("hap"));
	e = (double)(request.getAttribute("cha"));
	su1 = (double)(request.getAttribute("su1"));
	su2 = (double)(request.getAttribute("su2"));
}
%>


<h2>Servlet으로 만든 계산기</h2>
<form name='frm' method='post' action='hap.do'>
	<textarea rows="5" cols="30"><%=d %></textarea><br/>
	<input type='text' name='su1' value='<%=su1%>'/><br/>
	<input type='text' name='su2' value='<%=su2%>'/><br/>
	
	<input type='button' value='+' onclick='run(this.value)'/>
	<input type='button' value='-' onclick='run(this.value)'/>
	
	<input type='hidden' name='oper'/>
</form>

<script>
function run(oper){
	var frm = document.frm;
	frm.oper.value = oper;
	frm.submit();
}

</script>
</body>
</html>







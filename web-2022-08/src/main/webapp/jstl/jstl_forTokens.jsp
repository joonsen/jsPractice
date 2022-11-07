<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_forTokens</title>
<style>
.items{
	display: table-row;
	padding:5px;
}
.items>span{
	display: table-cell;
	background-color:#88f;
	width:100px;
}
</style>
</head>
<body>
<%
String tokens = "강아지, 고양이, 장미, 백합, 코스모스, 망아지";
pageContext.setAttribute("tokens", tokens);
%>
<c:forTokens var="i" items="${tokens }" delims="," varStatus="status">
	<div class='items'>
		<span>${i }</span>
		<span>${status.count }</span>
		<span>${status.index }</span>
	</div>
</c:forTokens>
</body>
</html>














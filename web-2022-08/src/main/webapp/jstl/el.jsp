<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/el.jsp</title>
</head>
<body>
<h2>EL Test</h2>
<form name='frm' method='post'>
	<span>Value</span>
	<input type='text' name='findStr' value='${param.findStr}'/>
	<input type='submit'/>
</form>

</body>
</html>
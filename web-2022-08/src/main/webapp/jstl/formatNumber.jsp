<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/formatNumber.jsp</title>
</head>
<body>
<h2>formatNumber | parseNumber</h2>
<fmt:formatNumber value='12345.6789' var='su' pattern='#,###,###.##'/>
su = ${su }<br/>
<fmt:formatNumber value='12345.6789' var='su2' pattern='0,000,000.00000000'/><!-- 위조방지 -->
su = ${su2 }
<hr/>
<fmt:parseNumber value='${su }' var='nSu' pattern='#,###,###.##' />
nSu = ${nSu }<br/>
<fmt:parseNumber value='${su }' var='nSu' pattern='#,###,###.##' integerOnly='true'/><!-- java는 이런 명령어 없음. 활용도 높음 -->
nSu = ${nSu }<br/>
<fmt:parseNumber value='${su }' var='nSu' pattern='#######.##' integerOnly='true'/><!-- java는 이런 명령어 없음. 활용도 높음 -->
nSu = ${nSu }<br/>



</body>
</html>
















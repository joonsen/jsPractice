<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>num_mission</title>
<style>
p{
	background-color:#444;
	color:#fff;
	padding:10px;
	box-sizing:border-box;
	border-radius:10px;
}
span{
	display:inline-block;
	width:80px;
	text-align:right;
}
output{
	display:inline-block;
	width:200px;
	height:20px;
	border-bottom:2px solid #aaa;
}
</style>
</head>
<body>
<p>
	수량, 단가를 입력받아 금액을 계산하고, 부가세 10%를 계산하여 합계를 출력하시오.
	단, 소숫점 이하는 절삭처리.(toFixed 또는 parseInt)
</p>
<form name='frm'>
	<span>수량</span>
	<input type='text' name='ea' value='1000'/><br/>
	<span>단가</span>
	<input type='text' name='price' value='1255'/><br/>
	<span>금액</span>
	<output name='amt'></output><br/>
	<span>부가세</span>
	<output name='tax'></output><br/>
	<span>총액</span>
	<output name='total'></output><br/>
	<input type='button' value='계산' name='btn'/>
</form>
<script>
let ea = Number(document.getElementByName("ea").value);
let price = Number(document.getElementByName("price").value);
let amt = ea*price;
let tax = amt*0.1;
let total = amt+tax;
let btn = document.getElementByName("btn");


btn.onclick = function(){
	
}


</script>

</body>
</html>











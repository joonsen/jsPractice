<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>num_mission</title>
<style>
div{
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
<div>
	수량, 단가를 입력받아 금액을 계산하고, 부가세 10%를 계산하여 합계를 출력하시오.
	단, 소숫점 이하는 절삭처리.(toFixed 또는 parseInt)
	<li>총액은 부가세 10%가 포함된 금액으로 수정
</div>
<form name='frm'>
	<span>수량</span>
	<input type='text' name='ea' value='123'/><br/>
	<span>단가</span>
	<input type='text' name='price' value='10'/><br/>
	<span>금액</span>
	<output name='amt'></output><br/>
	<span>부가세</span>
	<output name='tax'></output><br/>
	<span>총액</span>
	<output name='total'></output><br/>
	<input type='button' value='계산' name='btn'/>
</form>
<script>
let frm = document.frm;
frm.btn.onclick = function() {
	let ea = Number(frm.ea.value);
	let price = Number(frm.price.value);
	let amt = frm.amt;
	let tax = frm.tax;
	let total = frm.total;
	
	let temp = ea*price;
	let t = (temp/11);
	let v = temp-t;

	
	
	amt.value = v.toLocaleString();
	tax.value = t.toLocaleString();
	total.value = temp.toLocaleString();
}










function test(){ //function declaration
	let amt = 12345.6789;
	console.log( parseInt(amt));//소숫점 이하가 절삭
	console.log( parseInt(amt+0.5));//반올림
	console.log( parseInt(amt/10+0.5)*10) //12350
	console.log( parseInt(amt/100+0.5)*100); //12300
	
	console.log('_________________');
	console.log(amt.toFixed(0));
	console.log(amt.toFixed(1));
}
test();// 함수 호출

</script>

</body>
</html>
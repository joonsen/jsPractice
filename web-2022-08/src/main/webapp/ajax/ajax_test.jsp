<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/ajax_test.jsp</title>
<style>
#output>div{
	display: inline-block;
	width: 350px;
	padding: 20px;
	box-sizing: border-box;
	min-height: 250px;
	border:3px solid #aaa;
	vertical-align: top;
}
#output>#student{
	width: 705px;
	margin-top: 5px;
}
#output>#employee{
	width: 705px;
	margin-top: 5px;
}
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap");

select {
  /* 생략 */
  font-family: "Noto Sansf KR", sans-serif;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;

  color: #444;
  background-color: #fff;

  padding: 0.6em 1.4em 0.5em 0.8em;
  margin: 0;

  border: 1px solid #aaa;
  border-radius: 0.5em;
  box-shadow: 0 1px 0 1px rgba(0, 0, 0, 0.04);
}
select:hover {
  border-color: #888;
}

select:focus {
  border-color: #aaa;
  box-shadow: 0 0 1px 3px rgba(59, 153, 252, 0.7);
  box-shadow: 0 0 0 3px -moz-mac-focusring;
  color: #222;
  outline: none;
}

select:disabled {
  opacity: 0.5;
}
#output #append2{
width: 980px;
}
</style>
<script defer src='ajax_test.js'></script>
</head>
<body>
<h2>Ajax Test</h2>
<input type='button' value='Load Text File' id='btnLoadText'/>
<input type='button' value='Load Html File' id='btnLoadHtml'/>
<input type='button' value='Load JSP File' id='btnLoadJSP'/>
<input type='button' value='Load Json File' id='btnLoadJson'/>
<input type='button' value='학생정보 조회' id='btnStudent'/>
<input type='button' value='직원정보 조회' id='btnEmployee'/>

<input type='button' value='Append 1' id='btnAppend1'/>
<input type='button' value='Append 2' id='btnAppend2'/>

<hr/>
<div id='output'>
	<div id='text'></div>
	<div id='html'></div>
	<div id='jsp'></div>
	<div id='json'></div>
	<div id='student'>
		<div id='frm'></div>
		<div id='list'></div>
	</div>
	
	<div id='employee'>
		<div id='frm_employee'></div>
		<div id='employee_list'></div>
	</div>
	<div id='append1'>
		<div>
			<input type='button' id='btnInsert' value='추가'/>
			<input type='button' id='btnDelete' value='삭제'/>
		</div>
		<div id='appendZone'>
		</div>
	</div>
	<div id='append2'>
		<div>
			<span>지역</span><br/>
			<select id='city' size='5'>
				<option value='서울'>서울</option>
				<option value='부산'>부산</option>
				<option value='대구'>대구</option>
			</select>
		</div>
		<div>
			<span>상영관</span>
			<select id='theater' size='5'></select>
		</div>
		<div>
			<span>영화제목</span>
			<select id='movie' size='5'></select>
		</div>
	</div>
</div>
</body>
</html>
















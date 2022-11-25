/**
 * ajax test
 */

var btnText = document.querySelector('#btnLoadText');
var btnHtml = document.querySelector('#btnLoadHtml');
var btnJsp = document.querySelector('#btnLoadJSP');
var btnJson = document.querySelector('#btnLoadJson');


var divText = document.querySelector('#text');
var divHtml = document.querySelector('#html');
var divJsp = document.querySelector('#jsp');
var divJson = document.querySelector('#json');

var cnt = 0;

var btnInsert = document.querySelector('#btnInsert');

var city = document.querySelector('#city');
var theater = document.querySelector('#theater');
var movie = document.querySelector('#movie');

city.addEventListener('click',function(){
	var v = city.value;
	var xhr = new XMLHttpRequest();
	xhr.open('get','theater.jsp?city=' + v);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var data = JSON.parse(xhr.responseText);
			theater.length =0;
			console.log(data);
			for(d of data){
				var op = new Option(d,d);
				theater.appendChild(op);
			}
		}
	}
})

theater.addEventListener('click',function(){
	var v = theater.value;
	var xhr = new XMLHttpRequest();
	xhr.open('get','movie.jsp?theater=' + v);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState ==4){
			movie.length = 0;
			var data = JSON.parse(xhr.responseText);
			for(d of data){
				var op = new Option(d,d);
				movie.appendChild(op);
			}
		}
	}
})



btnInsert.addEventListener('click',function(){
	var appendZone = document.querySelector('#appendZone');
	
	//추가할 div를 생성
	var div = document.createElement("div"); //1)
	div.style.background= '#ddd';
	div.style.padding='5px';
	div.style.marginBottom="2px";
	
	var txt = document.createElement("input"); //2)
	
	txt.setAttribute("type", "text");
	txt.setAttribute("value", "하이" + cnt);
	
	div.appendChild(txt);
	
	var btn = document.createElement("input");//3)
	btn.setAttribute("type","button");
	btn.setAttribute("value", "삭제" +cnt); 
	div.appendChild(btn);
	/*div.addEventListener("click",fuction(ev){
		var tag = ev.srcElement;
		var parent = tag.
		
	})*/
	
	appendZone.appendChild(div);
})

/* 삭제 버튼--------------------*/
/*var btnDelete = document.querySelector("btnDelete");
btnDelete.addEventListener('click', function(){
	var appendZone = document.querySelector('#appendZone');
	appendzone.innerHTML;
})*/


btnText.addEventListener('click', function(){
	var xhr = new XMLHttpRequest(); //1)객체 생성
	//현업에서 이렇게 쓸일은 없을거야
	xhr.open('get', 'data.txt'); //2) 객체 초기화
	xhr.onreadystatechange = function(){// 3) 이벤트 핸들러 작성
		//5) 정상적으로 요청하고, 모든 응답정보를 수신 받았을 때
		if(xhr.status==200 && xhr.readyState==4){
			divText.innerHTML = xhr.responseText;
			//응답받은 text를 div영역에 뿌려준다 얘가 dom구조
		}
	}
	xhr.send(); //4)서버에게 요청처리
	
})

btnHtml.addEventListener('click', function(){
	
	/*
	이 일련의 과정을 jQuery를 쓰면
	$(divHtml).load('data.html');
	이 한줄로 끝난다..
	*/
	var xhr = new XMLHttpRequest();
	xhr.open('get', 'data.html');
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			divHtml.innerHTML = xhr.responseText;
		}	
	}
	xhr.send();
})

btnJsp.addEventListener('click',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('get', 'data.jsp?dan=5');	//get type으로 초기화
	xhr.onreadystatechange= function(){
		if(xhr.status==200 & xhr.readyState==4){
			divJsp.innerHTML = xhr.responseText;
		}
	}
	xhr.send();
})

btnJson.addEventListener('click', function(){
	
	var xhr = new XMLHttpRequest();
	xhr.open('get', 'data_json.jsp');
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			var data = xhr.responseText;
			var json = JSON.parse(data);
			var html = "<li>id:" +json.id
					  +"<li>name: " + json.name
					  +"<li>phone:" + json.phone;
			divJson.innerHTML = html;
		}
	}
	xhr.send();
	
})

std = function(){
	var btnSearch = document.querySelector('#btnSearch');
	var divList = document.querySelector('#list');
	btnSearch.addEventListener('click', function(){
		var xhr = new XMLHttpRequest();
		var findStr = document.frm.findStr.value;
		xhr.open('get','student_list.jsp?findStr=' + findStr); //parameter 던질거야
		xhr.onreadystatechange = function(){
			if(xhr.status==200 && xhr.readyState==4){
				var jsonArray = JSON.parse(xhr.responseText);
				/*divList.innerHTML = xhr.responseText;*/
				var html = "<div>";
				for(obj of jsonArray){
					html += "<div>"
						 + "	<span>" + obj.id + "</span>"
						 + "	<span>" + obj.name + "</span>"
						 + "	<span>" + obj.phone + "</span>"
						 + "	<span>" + obj.address + "</span>"
						 + "</div>";	
				}
				html += "</div>";
				divList.innerHTML = html;
			}
		}
		xhr.send();
	})
}
//메모리를 조금이라도 효율적으로 사용하자


//학생정보 조회
var btnStudent = document.querySelector('#btnStudent');
var frm = document.querySelector('#frm');
var list = document.querySelector('#list');

btnStudent.addEventListener('click',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('get', 'student_form.html');
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			frm.innerHTML = xhr.responseText;
			std();
		}
	}
	xhr.send();
})

//직원정보 조회
var btnEmployee = document.querySelector('#btnEmployee');
var frm_employee = document.querySelector('#frm_employee');
var employee_list = document.querySelector('#employee_list');

btnEmployee.addEventListener('click',function(){
	var xhr = new XMLHttpRequest(); //1.
	xhr.open('get','emp_form.html'); //2.초기화
	xhr.onreadystatechange = function(){ //3.
		if(xhr.status==200 && xhr.readyState==4){
			frm_employee.innerHTML = xhr.responseText;//응답정보가 text에 들어감
			emp();//5. 200번이면 정상적으로 요청이 끝났다. readyState 4면 정상적으로 모든 데이터 수신완료
		}
	}
	xhr.send();//4.초기화시킨 상태로 요청정보를 전송하겠다
})

emp = function(){
	var btnSearch = document.querySelector('#btnEmpSearch');
	var divList = document.querySelector('#employee_list');
	btnSearch.addEventListener('click', function(){
		var xhr = new XMLHttpRequest();
		var findStr = document.frm.empFindStr.value;
		xhr.open('get','emp_list.jsp?findStr=' + findStr); //parameter 던질거야
		xhr.onreadystatechange = function(){
			if(xhr.status==200 && xhr.readyState==4){
				var jsonArray = JSON.parse(xhr.responseText);
				var html = "<div>";
				for(obj of jsonArray){
					html += "<div>"
						 + "	<span>" + obj.employeeNumber + "</span>"
						 + "	<span>" + obj.lastName + "</span>"
						 + "	<span>" + obj.phone + "</span>"
						 + "	<span>" + obj.email + "</span>"
						 + "</div>";	
				}
				html += "</div>";
				divList.innerHTML = html;
			}
		}
		xhr.send();
	})
}
















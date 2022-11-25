/*
let frm = document.frm;
let now = new Date();
let data = {
	"서울" : [1,2,3,4,5],
	"부산" : [3,4,5],
	"인천" : [1,2,3,4],
	"대구" : [6,7,8,9],
	"제주" : [5,6,7,8,9,10]
}

//날짜와 시간을 설정
frm.nal.valueAsDate = now;
frm.sigan.value = now.toLocalString().slice(15);
console.log(now.toLocaleString());

//지역 설정
let keys = Object.keys(data);//{}형태의 자료에서 key만 가져옴
// 1) html 을 사용하여 태그를 만들어서 추가

let html;
for(k of keys){
	html += <option value="${k}">$(k)</option>;
}
frm.city.innerHTML = html;

//2)option 객체를 생성해서 추가
frm.city.length=0; // select box 초기화
for(k of keys){
	let op  = new Option(k,k);
	frm.city.options.add(op);
};


/////////////////////////////메뉴설정

frm.city.function(){
	let k = frm.city.value;
	let menu = data[k];
	console.log(frm.city.value);
	console.log(menu);
	//해당지역의 메뉴를 menu에 추가
	frm.menu.length=0;
	for(m of menu){
		let op = new Option(m,m);
		frm.menu.options.add(op);
	}	
}

frm.btn.addEventListener('click', function(ev){
	let html='';
	let report = document.querySelector('.report');
	html = `
	<h2>예약 확인서</h2>
	<span class='item'>지역</span>${frm.city.value} <br/>
	<span class='item'>메뉴</span>${frm.menu.value} <br/>
	<span class='item'>인원수</span>${frm.ea.value} <br/>
	<span class='item'>주문일</span>${frm.nal.value} <br/>
	<span class='item'>주문시간</span>${frm.sigan.value} <br/>
	`;
	report.innerHTML = html;
})




*/










/**
 * 
 */
let list =[]; //전체데이터 저장
function Score(serial, id, subject, score){
	this.serial = serial;
	this.id = id;
	this.subject = subject;
	this.score = score;
	this.output = function(){
		let str = `
		<div class='item'>
			<Span class='serial'>${this.serial}</Span>
			<span class='id'>${this.id}</span>
			<span class='subject'>${this.subject}</span>
			<span class='score'>${this.score}</span>
		</div>
		`;
		return str;
	}
}

//데이터 추가
function add(frm){
	let v;
	let item = document.querySelector('#item');
	
	//학번 입력 여부 체크
	if(frm.id.value==''){
		status.innerHTML = ('학번을 확인해 주세요');
		frm.id.focus();
		return;
	}
	
	//과목 입력 여부 체크
	if(frm.subject.value=='') {
		status.innerHTML = ('과목을 확인해 주세요.');
		frm.subject.focus();
		return;
	}
	
	//성적 입력 여부 체크
	if(frm.score.value=='' || isNan(frm.score.value)){
		status.innerHTML = ('성적을 확인해 주세요');
		frm.score.focus();
		return;
	}


	//form 값을 {}로 만들어 data에 push
	
	console.log(frm.id.value);
	
	v = { 'id': frm.id.value, 'subject': frm.subject.value,
	'score': frm.score.value};
	data.push(v);
	list();
}
	
function correct(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	if(index>=0){
		data[index].id = frm.id.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
	}
	
}

	
	



















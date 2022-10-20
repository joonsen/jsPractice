/**   수정필요한 파일
 * 성적관리 CRUD
	작성일: 2022.08(ljh) 
 */
let data=[
	{'id' : '1', 'subject' : '국어', 'score' : '50'},
	{'id' : '1', 'subject' : '영어', 'score' : '60'},
	{'id' : '2', 'subject' : '국사', 'score' : '80'}
];
let template;
list();
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for(v of data){
		template = 
			`
			<div class = 'item' onclick='view("${v.id}")'>
				<span class = 'id'>${v.id}</span>
				<span class = 'subject'>${v.subject}</span>
				<span class = 'score'>${v.score}</span>
			</div>
			`
		items.innerHTML += (template);
	}
}

function view(id){
	let index = data.findIndex(d=>d.id==id);
	console.log('찾은 위치:', index);
	let frm = document.frm_score;
	frm.id.value = data[index].id;
	frm.subject.value = data[index].subject;
	frm.score.value = data[index].score;
	
}

//데이터 추가
function add(frm){
	let v;
	let items = document.querySelector('#items');
	
	//학번 입력 여부 체크
	
	if(frm.id.value=='') {
		status.innerHTML = ('학번을 확인해 주세요.');
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
	if(frm.score.value=='' || isNaN(frm.score.value)){
		status.innerHTML = ('성적을 확인해 주세요.');
		frm.score.focus();
		return;
	}

	//form 값을 {}로 만들어 data에 push
	
	console.log(frm.id.value);
	
	v = {'id': frm.id.value, 'subject': frm.subject.value,
	'score': frm.score.value};
	data.push(v);	//배열 뒤에 추가 별로 좋은 방법은 아님
	list();
}
function correct(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	
	if(index>=0){
		data[index].id = frm.id.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
		list();
		status.innerHTML = ('데이터가 수정되었습니다');	
	} else{
		status.innerHTML = ('수정할 데이터가 없습니다');
	}
}

function deleteFunc(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	if(index>=0){
		data.splice(index,1);
		list();
		frm.id.value='';
		frm.subject.value='';
		frm.score.value='';
	} else {
		status.innerHTML = ('삭제할 자료를 찾지 못했읍니다');
	}
}












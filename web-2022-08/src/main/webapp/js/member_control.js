/**
 * 학생관리 CRUD
 * 작성일 :2022.08(ljh)
 */
let data=[
	{'id' : 'a001', 'name' : 'hong', 'gender' : 'm', 'phone' : '010-1111-1234'},
	{'id' : 'b001', 'name' : 'kim' , 'gender' : 'f', 'phone' : '010-2222-3333'},
	{'id' : 'c001', 'name' : 'lee' , 'gender' : 'f', 'phone' : '010-4444-4444'}
];
let template;
list ();
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for(v of data){
		template =
				`
				<div class = 'item' onclick='view("${v.id}")'>
					<span class = 'id'>${v.id}</span>
					<span class = 'name'>${v.name}</span>
					<span class = 'gender'>${v.gender}</span>
					<span class='phone'>${v.phone}</span>
				</div>
				`
		items.innerHTML+=(template);
	}
	
}

function view(id){
	let index = data.findIndex(d=>d.id==id);
	console.log('찾은 위치:', index);
	let frm = document.frm_member;
	frm.id.value = data[index].id;
	frm.name.value = data[index].name;
	frm.phone.value = data[index].phone;
	
	if(data[index].gender == 'm'){
		frm.gender[0].checked=true;
	} else {
		frm.gender[1].checked=true;
	}
	
	
}
//데이터 추가
function add(frm) {
	let gender;
	let v;
	let items = document.querySelector('#items');
	let index;
	
	// 아이디 중복 체크 type1
	index = data.findIndex( d=>d.id==frm.id.value);
	// 아이디 중복 체크 type2
	
	/*
	index = data.findIndex(function(v, index){
		let r = -1;
		if(v.id == frm.id.value) r=index;
		return r;	
	});
	*/
	
	
	if(index>=0) {
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	}
	
	
	
	//성별 체크 유무
	
	if (!frm.gender[0].checked && !frm.gender[1].checked){
		alert('성별을 체크해 주세요');
		return;
	}
	
	//이름 입력 여부 체크
	if(frm.name.value==''){
		alert('성명을 확인해 주세요');
		frm.name.focus();
		return;
	}
	
	//연락처 입력 여부 체크
	if(frm.phone.value == ''){
		alert('연락처를 확인해 주세요');
		frm.phone.focus();
		return;
	}
	
	
	if(frm.gender[0].checked) gender=frm.gender[0].value;
	else gender = frm.gender[1].value;

	//form 값을 {}로 만들어 data에 push
	
	console.log(frm.id.value);
	console.log('gender:' , gender);
	
	v={'id':frm.id.value, 'name':frm.name.value,
	'gender': gender, 'phone': frm.phone.value
	};
	data.push(v);	//배열 뒤에 추가
	template =
			`
			<div class = 'item' onclick='view("${v.id}")'>
				<span class = 'id'>${v.id}</span>
				<span class = 'name'>${v.name}</span>
				<span class = 'gender'>${v.gender}</span>
				<span class='phone'>${v.phone}</span>
			</div>
			`
		items.innerHTML += template;	//목록화면 뒤에 추가
}

function update(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	let g;//성별
	if(frm.gender[0].checked) g=frm.gender[0].value;
	else g = frm.gender[1].value;
	
	if(index>=0){ // 수정할 데이터가 있는 경우
		data[index].name = frm.name.value;
		data[index].phone = frm.phone.value;
		data[index].gender = g;
		list();
		alert('데이터가 수정되었습니다');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
}

function deleteFunc(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	if(index>=0){
		data.splice(index,1);
		list();
		frm.id.value='';
		frm.name.value='';
		frm.phone.value='';
		frm.gender[0].checked=false;
		frm.gender[1].checked=false;
	} else {
		alert('삭제할 자료를 찾지 못했습니다');
	}
	
}
/* 이미지 미리보기 --------------*/
let frm = document.frm_member;
function preview(){
	frm.photo.click();
}
frm.photo.onchange = function(ev){	
	let img = document.querySelector('.img');
	let file = ev.srcElement.files[0];
	let reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload=function(fev){
		img.src = this.result;
	}
}




























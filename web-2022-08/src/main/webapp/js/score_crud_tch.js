/**
 * score_crud.js
 */
let frm = document.frm;
let m_index=-1;

let list=[]; //전체데이터 저장
let subject = ['국어', '수학', '산수', '음약', '체육','바른생활','독서','국사','영어', '세계사']
function Score(serial, id, subject, score){
    this.serial = serial;
    this.id = id;
    this.subject = subject;
    this.score = score;
    this.output = function(){
        let str =`
            <div class='item' onclick='view(${this.serial})'>
                <span class='serial'>${this.serial}</span>
                <span class='id'>${this.id}</span>
                <span class='subject'>${this.subject}</span>
                <span class='score'>${this.score}</span>
            </div>
        `;
        return str;
    }
}
// sample data
for(let i=0; i<10; i++){
    let n = parseInt(Math.random()*100)+1;
    let s = parseInt(Math.random()*subject.length);
    let d = new Score((i+1), 'a00'+n, subject[s], n);
    list.push(d);
}

// 배열에 있는 과목을 사용하여 select 태그의 과목 설정
for(s of subject){
    frm.subject.options.add(new Option(s,s));
    
}

frm.findSerial.onclick = function(){
    m_index = frm.serial.value;
    view(m_index);
} 

frm.btnSave.onclick = function(){
    // serial 중복 체크
    let serial = frm.serial.value;
    let r = list.findIndex(d=>d.serial==serial)
    if(r>=0){
        alert('serial 중복');
        return;
    }
    if( !checkData()) {
        alert('데이터에 빈 값이 있구만');
        return;
    }
    
    d = new Score(serial,
                  frm.id.value,
                  frm.subject.value,
                  frm.score.value
                )
   list.push(d);  
   frm.btnOutput.click();  
} 

frm.btnUpdate.onclick = function(){
    if( !checkData()){
        alert('빈값은 안되는구만요...');
        return;
    }
    
    d = new Score(frm.serial.value,
                  frm.id.value,
                  frm.subject.value,
                  frm.score.value
                )
     list[m_index] = d;
     frm.btnOutput.click();
} 

frm.btnDelete.onclick = function(){
    if(m_index<=0){
        alert('자료가 선택되지 않았습니다.');
        return;
    }
    list.splice(m_index, 1);
    frm.btnOutput.click();
    m_index = -1;
} 

frm.btnOutput.onclick = function(){
    let items = document.querySelector('.items');
    let str = '';
    for(d of list){
        str += d.output();
     }
     items.innerHTML = str;
     
} 

function checkData(){
    let r=true;
    if(frm.serial.value == ''  || frm.id.value == '' ||
       frm.subject.value == '' || frm.score.value== ''){
        r=false;
    }
    return r;
}


function view(serial){
    m_index = list.findIndex(d => d.serial == serial);
    let d = list[m_index];
    frm.serial.value = d.serial;
    frm.id.value = d.id;
    frm.subject.value = d.subject;
    frm.score.value = d.score;
    
}
 
/* 목록 검색------------------- */
let btnFind = document.querySelector('#btnFind');
let findStr = document.querySelector('#findStr');
btnFind.onclick = find;

findStr.onkeyup = function(ev){
    if(ev.keyCode == 13) find();
}

function find(){
    let sp = findStr.value.split('');
    let imsi = list.filter(function(d){
        let r=false;
        for(f of sp){
            if(d.subject.indexOf(f)>=0 || d.id.indexOf(f)>=0) r=true;
        }
        return r;
    })
    
    frm.serial.value='';
    frm.id.value = '';
    frm.subject.value='';
    frm.score.value='';
    m_index = -1;
    
    let items = document.querySelector('.items');
    let str = '';
    for(d of imsi){
        str += d.output();
     }
     items.innerHTML = str;
} 

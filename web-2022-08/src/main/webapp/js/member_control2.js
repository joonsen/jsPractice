/**
 *   학생관리 CRUD 
 *   작성일 : 2022.08(pwg) 
 */
 let data=[
   {'id' : 'a001','name' : 'hong','gender' : 'm', 'phone' : '010-1111-1234'},
   {'id' : 'b001','name' : 'kim','gender' : 'f', 'phone' : '010-2222-3333'},
   {'id' : 'c001','name' : 'lee','gender' : 'f', 'phone' : '010-4444-4444'}   
];


 let frm = document.frm_member;
 let frmSearch2 = document.frmSearch2;
 
 
 frmSearch2.btnFind.onclick = list;
 
 function list(){
    let template;
    let items = document.querySelector('#items');
    items.innerHTML = '';    
    
    var xhr = new XMLHttpRequest();
    xhr.open('post', 'memberServlet.do?findStr='+frmSearch2.findStr.value);
    xhr.onreadystatechange = function(){
      if(xhr.status = 200 && xhr.readyState == 4){
         var data = JSON.parse(xhr.responseText);
         
         for(v of data){   //v는 각각의 배열을 뜻한다.
            template =
          `
            <div class='item' onclick='view("${v.id}")'>
               <span class='id'>${v.id}</span>
               <span class='name'>${v.name}</span>
               <span class='gender'>${v.gender}</span>
               <span class='phone'>${v.phone}</span>
            </div>
          `   
            items.innerHTML += (template);
         }
         
      }   
   }
   xhr.send();  //위로 옮겨도 될듯 속도차이 
}
list();
//배열에 저장된 id,name,phone,성별을 template에 집어 넣기. 
function view(id){
	let img = document.querySelector('.img');
	
	var xhr = new XMLHttpRequest();
	xhr.open('post','memberServlet.do?job=view&id=' + id);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			
		   var obj = JSON.parse(xhr.responseText);
		   
			frm.reset();
			
			frm.id.value = obj.id;
		   frm.name.value = obj.name;
		   frm.phone.value = obj.phone;
		   
		   if(obj.gender == 'm'){
		      frm.gender[0].checked=true;
		   }else{
		      frm.gender[1].checked=true;
		   }
			
		img.src = './upload/' + obj.sysFile;
		frm.delFile.value = obj.sysFile;
		}
	}
   
}

//데이터 추가
function add(frm){
   // console.log(frm.id.value); 여기서 찍을 수 있으면 배열에 넣을 수 있다는 것.
   let gender;
   let items = document.querySelector('#items');
   /*
	var xhr = new XMLHttpRequest();
	xhr.open('post','memberUpload.do');
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var obj = JSON.parse(xhr.responseText);
			frm.id.value = obj.id;
			frm.name.value = obj.name;
			frm.phone.value = obj.phone;
			
			if(obj.gender == 'm'){
				frm.gender[0].checked = true;
			}else{
				frm.gender[1].checked = true;
			}
			img.src='./upload/' + obj.sysFile;
		}
	}
*/


   // 성별 체크 유무   
   if(!frm.gender[0].checked&&!frm.gender[1].checked){
      alert('성별을 체크해 주세요.');
      return;   //함수 실행을 끊는다.      
   }
   
   // 이름 입력 여부 체크
   if(frm.name.value==''){
      alert('성명을 확인해 주세요.');
      frm.name.focus();
      return;
   }
   
   // 연락처 입력 여부 체크
   if(frm.phone.value == ''){
      alert('연락처를 확인해주세요.');
      alert.phone.focus();
      return;
   }
   
   // enctype이 있는 form을 multipart 타입으로 변환
   var fd = new FormData(frm);
   var xhr = new XMLHttpRequest();
   xhr.open('post', 'memberUpload.do?');
   xhr.onreadystatechange = function(){
      if(xhr.status == 200 && xhr.readyState==4){
         msg = xhr.responseText;
         alert(msg);
      }
   }
   xhr.send(fd);   
   
}



function update(frm){
   let gender;
   let items = document.querySelector('#items');
   var fd = new FormData(frm);
	var xhr = new XMLHttpRequest();
	xhr.open('post','memberUpload.do?job=update');
	xhr.send(fd);
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var obj = JSON.parse(xhr.responseText);
			frm.id.value = obj.id;
			frm.name.value = obj.name;
			frm.phone.value = obj.phone;
			
			if(obj.gender == 'm'){
				frm.gender[0].checked = true;
			}else{
				frm.gender[1].checked = true;
			}
			img.src='./upload/' + obj.sysFile;
		}
	}



   // 성별 체크 유무   
   if(!frm.gender[0].checked&&!frm.gender[1].checked){
      alert('성별을 체크해 주세요.');
      return;   //함수 실행을 끊는다.      
   }
   
   // 이름 입력 여부 체크
   if(frm.name.value==''){
      alert('성명을 확인해 주세요.');
      frm.name.focus();
      return;
   }
   
   // 연락처 입력 여부 체크
   if(frm.phone.value == ''){
      alert('연락처를 확인해주세요.');
      alert.phone.focus();
      return;
   }
   
   // enctype이 있는 form을 multipart 타입으로 변환
   var fd = new FormData(frm);
   var xhr = new XMLHttpRequest();
   xhr.open('post', 'memberUpload.do?job=update');
   xhr.onreadystatechange = function(){
      if(xhr.status == 200 && xhr.readyState==4){
         msg = xhr.responseText;
         alert(msg);
      }
   }
   xhr.send(fd);   
   
}



function deleteFunc(frm){
    var id = frm.id.value;
	var delFile = frm.delFile.value;
	var url = `memberServlet.do?job=delete&id=${id}&delFile=${delFile}`;
	var xhr = new XMLHttpRequest();
	xhr.open('post', url);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var msg = xhr.responseText;
			alert(msg);
			document.frmSearch2.btnFind.click();
		}
	}
}


 let btnFile = document.querySelector('#photo_file');      
      let photo = document.querySelector('#photo');
      
      photo.onclick = function(){
         btnFile.click();
      }
      
      btnFile.onchange = function(ev){
         let file = ev.srcElement.files[0];
         let reader = new FileReader();
         reader.readAsDataURL(file);
         reader.onload=function(fev){
            let tempImg = new Image();
            tempImg.src = this.result;
            photo.src = tempImg.src;
         }
      }      
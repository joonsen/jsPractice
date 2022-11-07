/**
 * 학생관리
 */

/* 입력 화면 처리 --------------------------*/
var frmInput = document.frm_input;

if(frmInput != null){
   frmInput.btnCancel.onclick=function(){   //취소버튼
      frmInput.action='student.do?job=select';	//servlet을 부를때 param을 job이라고 줘서
      frmInput.submit();   //submit을 날려 액션을실행
   }

   // servlet을 직접 호출하지 않고 useBean으로 객체를 만든 후
	// servlet을 호출하는 result.jsp를 호출
   frmInput.btnSave.onclick=function(){   //저장버튼
      frmInput.action='result.jsp?job=insertR';	//경유지점
      frmInput.submit();
   }
}



/* 조회 화면------------------------------*/
//btnInsert버튼(입력버튼)을 클릭하면 student_input_form2.jsp로 메인컨텐츠가 바뀌도록
var frmSearch = document.frm_search;
if(frmSearch != null){
   frmSearch.btnInsert.addEventListener('click',function(){
      frmSearch.action='student.do?job=insert';
      frmSearch.submit();
   });
   
   frmSearch.btnSelect.onclick=function(){ //frmSearch폼태그안에 있는 btnSelect(조회버튼)가 클릭되면 frmSearch폼태그가 액션을하는데
      frmSearch.action='student.do?job=select';
      frmSearch.nowPage.value=1;      //조회버튼을눌렀을때 해당페이지를나타내는 nowPage는 1페이지로 나오게끔 코딩
      frmSearch.submit();
   }
}
   
function movePage(nowPage){		
      frmSearch.action='student.do?job=select';
      frmSearch.nowPage.value=nowPage;      // 맨 처음을 누르면 1이 나오고... 현재 페이지 value가 나와야지
      frmSearch.submit();
}

function view(id){
	frmSearch.action='student.do?job=update&id=' + id; //get type으로 넘길때
	//frmSearch.id.value=id;
	frmSearch.submit();
}

/* 상세보기, 수정, 삭제------------------------------------*/
var btnSelect = document.querySelector("#btnSelect");
if(btnSelect != null){
	btnSelect.onclick = function(){
		var frm = document.frm_student;
		frm.action = 'student.do?job=select';
		frm.submit();
	}
}



/*수정--------*/

var btnModify = document.querySelector('#btnModify');
if(btnModify != null){
	var frm = document.frm_student;
	btnModify.onclick = function(){
	frm.action = 'result.jsp?job=updateR';
	frm.submit();
	}
}

/*삭제-----------*/

var btnDelete = document.querySelector('#btnDelete');
if(btnDelete != null){
	var frm = document.frm_student;
	btnDelete.onclick = function(){
	frm.action = 'result.jsp?job=deleteR';
	frm.submit();
	}
}















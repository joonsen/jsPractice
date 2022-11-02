/**
 * 학생관리
 */

/* 입력화면 처리 */
var frmInput = document.frm_input;
if(frmInput != null){
	frmInput.btnCancel.onclick=function(){
		frmInput.action='index.jsp?inc=student/student_list.jsp';
		frmInput.submit();
	}
	
	frmInput.btnSave.onclick = function(){
		frmInput.action='index.jsp?inc=student/student_input_result.jsp';
		frmInput.submit();
	}
}




/* 조회 화면 처리  */

var frmSearch = document.frm_search;
if(frm.Search.btnInsert != null){
	frmSearch.btnInsert.addActionListener('click', function(){
	frmSearch.action='index.jsp?inc=student/student_input_form.jsp';
	frmSearch.submit();
	});
}












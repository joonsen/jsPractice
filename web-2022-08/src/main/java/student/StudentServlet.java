package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/student.do")
public class StudentServlet extends HttpServlet{
	String path = "index.jsp?inc=student/";
	StudentDao dao;
	
	public StudentServlet() {
		dao = new StudentDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(dao==null) dao = new StudentDao(); //session이 죽었을땐 dao가 날라갈 수 있으므로..예방책
		
		System.out.println("get..나야 나~");
		Page pageVo = new Page();
		
		select(pageVo, req, resp);
		
	}
	//servlet을 호출한거
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		if(dao==null) dao = new StudentDao();
		
		  String job = req.getParameter("job");
	      String url = "";
	      RequestDispatcher rd = null;
	      
	      System.out.println(job);
	      
	      Page pageVo = new Page();
	      pageVo.setFindStr(req.getParameter("findStr"));
	      pageVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
	      
	      req.setAttribute("pageVo", pageVo);
	      
	      switch(job) {
	      case "select":         
	         select(pageVo, req, resp);
	         break;
	      case "insert":
	         url = path + "student_input_form.jsp";
	         rd = req.getRequestDispatcher(url);
	         rd.forward(req, resp);
	      case "insertR":
	    	  StudentVo sVo = (StudentVo)req.getAttribute("sVo");
	    	  
	    	  if(insertR(sVo,resp) ) {
	    		select(pageVo, req, resp);  
	    	  }	//sVo를 저장
	    	  else {
	  		
	  			PrintWriter out = resp.getWriter();
	  			out.print("<script>");
	  			out.print(" alert(자료에 오류가 발생);");
	  			out.print(" history.back(); ");	//입력폼으로 다시 이동
	  			out.print("</script>");
	    	  }
	    	  break;
	      case "update":
	    	  update(req, resp);
	      		break;
	      case "updateR":
	    	  updateR(req, resp);
	      		break;
	      case "deleteR":
	    	  deleteR(req, resp);
	    	  break;
	      
	      }      

	}

	public void select(Page pageVo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		List<StudentVo> list = dao.select(pageVo);
		dao.close();
		
		String url = path + "student_list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("list", list);
		req.setAttribute("pageVo", pageVo);
		
		rd.forward(req, resp);
	}

	
	public boolean insertR(StudentVo sVo, HttpServletResponse resp) throws ServletException, IOException{
		if(dao==null) dao = new StudentDao();
		
		boolean b = dao.insert(sVo);
		return b;
	}
	
	public void update (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(dao==null) dao = new StudentDao();
		String url = path + "student_modify.jsp";
		String id = req.getParameter("id");
		StudentVo vo = dao.view(id);
		
		Page pageVo = new Page();
		pageVo.setFindStr(req.getParameter("findStr"));
		pageVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("vo", vo);
		req.setAttribute("pageVo", pageVo);
		
		rd.forward(req, resp);
	}
	
	public void updateR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		StudentVo sVo = (StudentVo)req.getAttribute("sVo");
		Page pageVo = (Page)req.getAttribute("pageVo");
	
		
		boolean b = dao.modify(sVo);
		if(b) {
			select(pageVo, req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("	alert('자료 삭제시 오류가 발생!');");
			out.print(" history.back();");
			out.print("</script>");
			
		
		}
	}
		
	public void deleteR(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		if(dao==null) dao = new StudentDao();
		StudentVo sVo = (StudentVo)req.getAttribute("sVo");
		Page pageVo = (Page)req.getAttribute("pageVo");
		boolean b = dao.delete(sVo);
		if(b) {
			select(pageVo, req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("	alert('자료 삭제시 오류가 발생!');");
			out.print(" history.back();");
			out.print("</script>");
			
		}
	}
}










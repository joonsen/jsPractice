package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/sbs.kr", "/servlet/mbc.kr"})
public class TestServlet extends HttpServlet{		//httpServlet을 상속하려면 특정 메소드를 재정의해야한다

	@Override	//form을 간단히 만들어 get으로 했을때 호출되는지, post로 했을때 호출되는지 확인할거야
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request객체(instance)의 full name은 사실 HttpServletRequest였다!.response객체는 HttpServletResponse
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");

		System.out.println("get으로 호출됨");
		System.out.println("id: " + id);
		System.out.println("phone: " + phone);
		
		//결과 전송
		RequestDispatcher rd = req.getRequestDispatcher("test_servlet.jsp");
		rd.forward(req, resp); //test_servlet.jsp 에 다시 되돌려준다
	}		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		
		System.out.println("post로 호출됨");
		System.out.println("id: " + id);
		System.out.println("phone: " + phone);
		
		//결과 전송
		RequestDispatcher rd = req.getRequestDispatcher("../index.jsp");
		rd.forward(req, resp);	//request 정보가 그대로 relation 되는데, url이 안바뀐다
	}

}










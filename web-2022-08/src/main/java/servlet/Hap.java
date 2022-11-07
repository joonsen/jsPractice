package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/hap.do")
public class Hap extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double su1 = Double.parseDouble(req.getParameter("su1"));
		double su2 = Double.parseDouble(req.getParameter("su2"));
		
		double hap = su1 + su2;
		double cha = su1 - su2;
		
		req.setAttribute("hap", hap);
		req.setAttribute("cha", cha);
		req.setAttribute("su1", su1);
		req.setAttribute("su2", su2);
		
		RequestDispatcher rd = req.getRequestDispatcher("hap.jsp");
		rd.forward(req, resp);
	}

}











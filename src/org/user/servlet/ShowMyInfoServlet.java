package org.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.user.entity.Student;

/**
 * Servlet implementation class ShowMyInfoServlet
 */
@WebServlet("/ShowMyInfoServlet")
public class ShowMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();				
		request.setCharacterEncoding("utf-8");
						
		Student studentInfo = (Student)session.getAttribute("student");
		
		session.setAttribute("sname", studentInfo.getSname());
		session.setAttribute("sgender", studentInfo.getSgender());
		session.setAttribute("suniv", studentInfo.getSuniv());
		session.setAttribute("syear", studentInfo.getSyear());
		session.setAttribute("smajor", studentInfo.getSmajor());
		session.setAttribute("smodule", studentInfo.getSmodule());
		session.setAttribute("sqna", studentInfo.getQuestions());	
		session.setAttribute("semail", studentInfo.getSemail());		
		session.setAttribute("sidentiy", studentInfo.getSidentity());	
				
		response.sendRedirect("/online_learning_platform/HTML/profile.jsp");
	//	request.getRequestDispatcher("Homepage/myInfo.jsp").forward(request, response);
//		request.getRequestDispatcher("../Homepage/myInfo.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

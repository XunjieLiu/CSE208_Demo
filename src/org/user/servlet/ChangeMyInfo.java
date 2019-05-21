package org.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.user.entity.Student;
import org.user.service.IStudentService;
import org.user.service.ITeacherService;
import org.user.service.impl.StudentServiceImpl;
import org.user.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class ChangeMyInfo
 */
@WebServlet("/ChangeMyInfo")
public class ChangeMyInfo extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean result = false;
		
		int identity = 0;
		request.setCharacterEncoding("utf-8");
		Student student = (Student)session.getAttribute("student");

		String sname = session.getAttribute("sname").toString();
		String suniv = request.getParameter("suniv");
		int syear =Integer.parseInt(request.getParameter("syear")) ;
		String smajor = request.getParameter("smajor");
		
		System.out.println(sname);
		System.out.println(suniv);
		System.out.println(syear);
		System.out.println(smajor);
		
		if (identity==0) {
			// This is a student.
			session.setAttribute("identity", "0");			
			
			student.setSname(sname);
			student.setSuniv(suniv);
//			student.setSyear(syear);  
			student.setSmajor(smajor);
			student.setSidentity(identity);
			
			session.setAttribute("student", student);
			
			IStudentService sservice = new StudentServiceImpl();
				
			result =sservice.updateAllInfoByName(student);
		} else {
			// This is a teacher.				
			ITeacherService tservice = new TeacherServiceImpl();
		}
		
		if (result) {
			response.sendRedirect("/online_learning_platform/HTML/dashboard.jsp");
		
			request.setAttribute("status", true);
		} else {
			response.sendRedirect("Login/loginFail.jsp");
		}
	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

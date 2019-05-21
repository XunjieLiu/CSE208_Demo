package org.user.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.user.dao.impl.StudentDaoImpl;
import org.user.entity.Student;
import org.user.service.IStudentService;
import org.user.service.impl.StudentServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/SetQuestionServlet")
public class SetQuestionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		HashMap<String, String> map = new HashMap<String, String>();
		
		String q1 = request.getParameter("q1");	
		String a1 = request.getParameter("answer1");
		
		map.put(q1, a1);
//		map.put(q2, a2);
//		map.put(q3, a3);
		
		
		String qna = q1 + "," + a1;
		student.setQuestions(map);
		IStudentService studentService = new StudentServiceImpl();
		studentService.addStudent(student);
		
		session.setAttribute("student", student);
		
		response.sendRedirect("/online_learning_platform/HTML/login.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

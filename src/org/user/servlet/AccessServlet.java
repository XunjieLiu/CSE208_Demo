package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.user.dao.impl.StudentDaoImpl;
import org.user.entity.Student;
import org.user.entity.Teacher;
import org.user.service.IStudentService;
import org.user.service.ITeacherService;
import org.user.service.impl.StudentServiceImpl;
import org.user.service.impl.TeacherServiceImpl;

@WebServlet("/AccessServlet")
public class AccessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean result = false;

		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String identity = request.getParameter("identity"); // identity前端传来默认是0，默认是学生

		request.setAttribute("identity", "0");
		Student student = new Student(name.trim(), pwd.trim());
		IStudentService sservice = new StudentServiceImpl();
			
		result=  sservice.queryByNameAndPassword(student);

		if (result) {
			HttpSession session = request.getSession(true);
			StudentDaoImpl dao = new StudentDaoImpl();
			Student newStudent = dao.queryAllInfoByStudent(student);
			session.setAttribute("student", newStudent);
			response.sendRedirect("/online_learning_platform/HTML/dashboard.jsp");
//			request.getRequestDispatcher("/HTML/dashboard.html").forward(request, response);
//			request.setAttribute("status", true);
		} else {
			System.out.println(result);
			response.sendRedirect("/online_learning_platform/HTML/login.html");
		}

		// request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
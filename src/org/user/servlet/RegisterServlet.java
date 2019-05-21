package org.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.user.dao.impl.StudentDaoImpl;
import org.user.entity.Student;

/**
 * Servlet implementation class RegisterServlet
 */
@SuppressWarnings("serial")
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("I am register servlet");
		
		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int identity = request.getParameter("identity").equals("student")? 0:1;
		int year = Integer.parseInt(request.getParameter("year"));
		String pwd = request.getParameter("pwd");
		String major = request.getParameter("major");

		Student student = new Student(name, identity, year, major, email);
		student.setSpwd(pwd);

		session.setAttribute("student", student);
		session.setAttribute("sname", student.getSname());
		
		System.out.println(student.toString());
		
		response.sendRedirect("/online_learning_platform/HTML/register_security.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

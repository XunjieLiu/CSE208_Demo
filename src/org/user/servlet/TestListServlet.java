package org.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import org.user.entity.Student;

@WebServlet("/TestListServlet")
public class TestListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is test servlet");
		Student student1 = new Student("Xunjie", "123");
		Student student2 = new Student("John", "afds3");
		Student student3 = new Student("Sam", "1sdgs");
		Student student4 = new Student("James", "srggrg");
		Student student5 = new Student("Kevin", "agsfgsf");
		
		List<Student> list  = new ArrayList<Student>();
		list.add(student5);
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		
		request.setAttribute("student", list);
		request.getRequestDispatcher("showList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package org.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UploadGetModuleServlet
 */
@SuppressWarnings("serial")
@WebServlet("/UploadGetModuleServlet")
public class UploadGetModuleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String module = request.getParameter("uploadselect");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("module", module);
		System.out.println(session.getAttribute("module"));
//		request.getRequestDispatcher("/HTML/Other.html").forward(request, response);
		response.sendRedirect("/online_learning_platform/HTML/Other.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

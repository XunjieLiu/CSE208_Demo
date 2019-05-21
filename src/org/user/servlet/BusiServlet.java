package org.user.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.file.dao.ReadFileList;

/**
 * Servlet implementation class BusiServlet
 */
@WebServlet("/BusiServlet")
public class BusiServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This is busi servlet");
		HttpSession session = request.getSession(true);
		
		if(session.isNew()) {
			System.out.println("This is a new session ");
		}else {
			String url = "C:\\Eclipse\\online_learning_platform\\WebContent\\HTML\\down_file\\busi";
			ReadFileList filelist = new ReadFileList();
			List<File> list = filelist.test(url);
			session.setAttribute("file_list", list);
		}
		
//		request.getRequestDispatcher("/HTML/down_pages/arc.jsp").forward(request, response);
		response.sendRedirect("/online_learning_platform/HTML/down_pages/busi.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package org.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject json=new JSONObject();
        JSONArray array=new JSONArray();

        JSONObject temp1=new JSONObject();
        JSONObject temp2=new JSONObject();

        try {
            temp1.put("name", "file");
            temp1.put("type", ".txt");
            array.put(0,temp1);

            temp2.put("name", "Image");
            temp2.put("type", ".jpeg");
            array.put(1,temp2);    
            
            temp2.put("name", "orcle");
            temp2.put("type", ".pdf");
            array.put(1,temp2);    

            json.put("fileList", array);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrintWriter out=response.getWriter();
        out.println(json);
        out.close();
    }

}

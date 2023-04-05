package com.hib;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		
		case "delete":
			String id = request.getParameter("id");

			 StudentDao.DeleteStudentDetails(id);
			response.sendRedirect("AllStuden_Details.jsp");  
			 break;
			 
		case "update":	
			String id1 = request.getParameter("id");
			Student student =StudentDao.getStudentByid(Integer.parseInt(id1));
			request.setAttribute("student", student);
			request.getRequestDispatcher("UpdateStudentDetails.jsp").forward(request, response);
			 
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "save": 
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			Student e = new Student();
			e.setName(name);
			e.setEmail(email);
			e.setPassword(password); 
			
			
	       StudentDao.save(e);
			 
			 response.sendRedirect("Index.jsp");
			 out.close();
			 
			 break;
			 
		case "update":
			String uid = request.getParameter("id");
			int id1 = Integer.parseInt(uid);
			String uname = request.getParameter("name");
			String uemail = request.getParameter("email");
			String upassword = request.getParameter("password");
			
			Student e1 = new Student();
			e1.setId(id1);
			e1.setName(uname);
			e1.setEmail(uemail);
			e1.setPassword(upassword); 
			StudentDao.update(e1);
			
			 response.sendRedirect("AllStuden_Details.jsp");
			 
			
			
			break;
		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

}

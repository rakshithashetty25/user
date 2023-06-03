package com.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.dao.AdminDao;


@WebServlet("/My")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean status = AdminDao.checkLogin(name, password);
		System.out.println(status);
		if(status)
		{
		out.print("<h1>Login Successfull</h1>");
	}
		else
		{
			//response.sendRedirect("admin.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

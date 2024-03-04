package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello.html")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("method", "GET");
		request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("method", "POST");
		request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String who = request.getParameter("who");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Echo message</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>method : DELETE</h1>");
		out.println("<h1> To : "+who+"</h1>");
		out.println("<h1> Message : "+message+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	

}








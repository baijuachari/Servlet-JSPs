package com.baiju.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlServlet
 */
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello from GET method again");
		PrintWriter writer = response.getWriter();
		// servlet example passing parameter
		// http://localhost:8080/SimpleServlet/myservlet?userName=Baiju
		// OR use the followign URL
		// http://localhost:8080/SimpleServlet/SampleForm.html
		String userName = request.getParameter("userName");
		writer.print("Hello from XML doGet method: "+userName);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello from Post method again");
		PrintWriter writer = response.getWriter();
		// servlet example passing parameter
		// http://localhost:8080/SimpleServlet/myservlet?userName=Baiju
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		writer.print("Hello from XML doPost method: username "+userName + "  fullName: "+ fullName);
		writer.print("you are a " + prof);
		writer.print("you are at " + location.length + "places");
//		for (String loc: location) {
//			writer.print("Location: "+loc);
//		}
	}
}

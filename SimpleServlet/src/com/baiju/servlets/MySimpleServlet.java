package com.baiju.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MySimpleServlet
 */
//@WebServlet(description = "A simple servlet", urlPatterns = {"/MySimpleServletPath"},
//			initParams={@WebInitParam(name="defaultUser", value="John Doe")})
public class MySimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MySimpleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method Thread" + Thread.currentThread().getName());
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		//Using session to save the userName attribute.
		PrintWriter writer = response.getWriter();
		writer.println("SimleServlet request username :" + userName);
		writer.println("SimleServlet session username :" + session.getAttribute("savedUserName"));
		writer.println("SimleServlet context username :" + context.getAttribute("savedUserName"));
		writer.println("SimleServlet init param has defaultion username :" + this.getServletConfig().getInitParameter("defaultUser"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

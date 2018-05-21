package com.servlet.listener.httpSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession httpSession = null;
		RequestDispatcher dispatcher = null;

		if ("pravin".equals(username) && "password".equals(password)) {
			httpSession = request.getSession();
			httpSession.setAttribute("username", username);

			dispatcher = request.getRequestDispatcher("welcome.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("failure.jsp");
		}

		dispatcher.forward(request, response);
	}

}

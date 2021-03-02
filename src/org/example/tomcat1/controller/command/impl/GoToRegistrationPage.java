package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.command.Command;

public class GoToRegistrationPage implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		if (session == null) {
			response.sendRedirect("Controller?command=gotoindexpage");
			
			return;
		}
		
		String url = request.getRequestURL() + "?" + request.getQueryString();
			
		session.setAttribute("url", url);	
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		requestDispatcher.forward(request, response);		
	}
}

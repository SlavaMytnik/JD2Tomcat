package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.User;
import org.example.tomcat1.controller.command.Command;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;
import org.example.tomcat1.service.UserService;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ServiceProvider provider = ServiceProvider.getInstance();
		
		UserService userService = provider.getUserService();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");		

		if (login == null || login.length() < 4 || login.length() > 100 
				|| password == null || password.length() < 4 || password.length() > 100 
				|| !login.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| !password.matches("[à-ÿÀ-ßa-zA-Z0-9]+")) {
			response.sendRedirect("Controller?command=gotoredirectpage&error=logination");
			
			return;
		}

		try {
			LoginationInfo info = new LoginationInfo(login, password);
			
			User user = userService.logination(info);
			
			if (user == null) {
				response.sendRedirect("Controller?command=gotoredirectpage&error=logination");
				
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			session.setAttribute("username", login);
			session.setAttribute("role", user.getRole());
			
			response.sendRedirect("Controller?command=gotomainpage");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

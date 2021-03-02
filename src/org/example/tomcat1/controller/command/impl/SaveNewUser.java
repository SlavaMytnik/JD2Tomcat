package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.controller.command.Command;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;
import org.example.tomcat1.service.UserService;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String status = "active";
		String role = "user";

		if (login == null || login.length() < 4 || login.length() > 100 
				|| password == null || password.length() < 4 || password.length() > 100 
				|| !login.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| !password.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| (name.length() > 0 && !name.matches("[à-ÿÀ-ßa-zA-Z0-9]+")) 
				|| (surname.length() > 0 && !surname.matches("[à-ÿÀ-ßa-zA-Z0-9]+"))
				|| name.length() > 100 || surname.length() > 100) {
			response.sendRedirect("Controller?command=gotoredirectpage&error=registration");
			
			return;
		}
	
		try {
			RegistrationInfo regInfo = new RegistrationInfo(login, password, name, surname, status, role);

			UserService userService = provider.getUserService();

			Boolean regResult = userService.registration(regInfo); 
			
			if (!regResult) {
				response.sendRedirect("Controller?command=gotoredirectpage&error=registration");
				
				return;
			}
		
			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			session.setAttribute("username", login);
			session.setAttribute("role", role);

			response.sendRedirect("Controller?command=gotomainpage");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

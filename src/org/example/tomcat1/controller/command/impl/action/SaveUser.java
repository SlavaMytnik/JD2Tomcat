package org.example.tomcat1.controller.command.impl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;
import org.example.tomcat1.service.IUserService;

import static org.example.tomcat1.controller.command.impl.CommandConstants.*;

public class SaveUser implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSession(request, response)) return;
		
		ServiceProvider provider = ServiceProvider.getInstance();
		
		String login = request.getParameter(PAR_OR_ATTR_LOGIN);
		String password = request.getParameter(PAR_OR_ATTR_PASSWORD);
		String name = request.getParameter(PAR_OR_ATTR_NAME);
		String surname = request.getParameter(PAR_OR_ATTR_SURNAME);
		String status = STATUS_ACTIVE;
		String role = ROLE_USER;
		
		RegistrationInfo regInfo = new RegistrationInfo(login, password, name, surname, status, role);
		
		if (!bouncer.checkRegistrationInfo(response, regInfo)) return;
		
		try {
			IUserService userService = provider.getUserService();

			Boolean regResult = userService.registration(regInfo); 
			
			if (!regResult) {
				response.sendRedirect("Controller?command=gotoredirectpage&" + PAR_OR_ATTR_ERROR + "=" + ERROR_REGISTRATION);
				
				return;
			}
		
			HttpSession session = request.getSession(true);
			session.setAttribute(PAR_OR_ATTR_AUTH, true);
			session.setAttribute(PAR_OR_ATTR_USERNAME, login);
			session.setAttribute(PAR_OR_ATTR_ROLE, role);

			response.sendRedirect("Controller?command=gotomainpage");
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
}

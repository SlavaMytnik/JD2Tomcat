package org.example.tomcat1.controller.command.impl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.User;
import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.controller.command.impl.CommandConstants;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;
import org.example.tomcat1.service.IUserService;

public class Login extends CommandConstants implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSession(request, response)) return;
		
		ServiceProvider provider = ServiceProvider.getInstance();
		
		IUserService userService = provider.getUserService();
		
		String login = request.getParameter(PAR_OR_ATTR_LOGIN);
		String password = request.getParameter(PAR_OR_ATTR_PASSWORD);	
		
		LoginationInfo logInfo = new LoginationInfo(login, password);
		
		if (!bouncer.checkLoginationInfo(response, logInfo)) return;
		
		try {			
			User user = userService.logination(logInfo);
			
			if (user == null) {
				response.sendRedirect("Controller?command=gotoredirectpage&" + PAR_OR_ATTR_ERROR 
						+ "=" + ERROR_LOGINATION);
				
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute(PAR_OR_ATTR_AUTH, true);
			session.setAttribute(PAR_OR_ATTR_USERNAME, login);
			session.setAttribute(PAR_OR_ATTR_ROLE, user.getRole());
			
			response.sendRedirect("Controller?command=gotomainpage");
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
}

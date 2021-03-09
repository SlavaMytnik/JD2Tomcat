package org.example.tomcat1.controller.command.impl.gotopage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.controller.command.impl.CommandConstants;
import org.example.tomcat1.service.ServiceException;

public class GoToRedirectPage extends CommandConstants implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ServiceException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSession(request, response)) return;

		request.setAttribute(PAR_OR_ATTR_ERROR, request.getParameter(PAR_OR_ATTR_ERROR));	
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page_redirect.jsp");
		requestDispatcher.forward(request, response);		
	}
}



package org.example.tomcat1.controller.command.impl.gotopage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.controller.command.impl.CommandConstants;

public class GoToRegistrationPage extends CommandConstants implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSession(request, response)) return;
		
		HttpSession session = request.getSession();		
		
		String url = request.getRequestURL() + "?" + request.getQueryString();
			
		session.setAttribute(PAR_OR_ATTR_URL, url);	
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page_registration.jsp");
		requestDispatcher.forward(request, response);		
	}
}

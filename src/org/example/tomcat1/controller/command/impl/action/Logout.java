package org.example.tomcat1.controller.command.impl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.controller.command.impl.CommandConstants;

public class Logout extends CommandConstants implements ICommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSessionAndAuth(request, response)) return;
		
		HttpSession session = request.getSession();		
		
		session.removeAttribute(PAR_OR_ATTR_AUTH);
		session.removeAttribute(PAR_OR_ATTR_USERNAME);
		session.removeAttribute(PAR_OR_ATTR_ROLE);
		
		response.sendRedirect("Controller?command=gotoindexpage");		
	}
}

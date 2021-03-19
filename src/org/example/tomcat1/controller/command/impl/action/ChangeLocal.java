package org.example.tomcat1.controller.command.impl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;

import static org.example.tomcat1.controller.command.impl.CommandConstants.*;

public class ChangeLocal implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSession(request, response)) return;
		
		HttpSession session = request.getSession();		

		String local = request.getParameter(PAR_OR_ATTR_LOCAL);
		
		session.setAttribute(PAR_OR_ATTR_LOCAL, local);
		
		String url = (String) session.getAttribute(PAR_OR_ATTR_URL);

		response.sendRedirect(url);
	}
}

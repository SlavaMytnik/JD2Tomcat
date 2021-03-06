package org.example.tomcat1.controller.command.impl.action;

import static org.example.tomcat1.controller.ControllerConstants.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;

public final class Logout
	implements ICommand{

	@Override
	public void execute(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException,
			ControllerException {
		CommandBouncer bouncer = new CommandBouncer();

		if (!bouncer.checkSessionAndAuth(request, response)) {
			return;
		}

		HttpSession session = request.getSession();

		session.removeAttribute(PAR_OR_ATTR_AUTH);
		session.removeAttribute(PAR_OR_ATTR_USERNAME);
		session.removeAttribute(PAR_OR_ATTR_ROLE);

		response.sendRedirect("Controller?"
				+ "command=gotoindexpage");
	}
}

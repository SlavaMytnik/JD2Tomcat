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

public final class ChangeLocal
	implements ICommand {

	@Override
	public void execute(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException,
			ControllerException {
		CommandBouncer bouncer = new CommandBouncer();

		if (!bouncer.checkSession(request, response)) {
			return;
		}
		
		String local = request.getParameter(PAR_OR_ATTR_LOCAL);

		HttpSession session = request.getSession();
		session.setAttribute(PAR_OR_ATTR_LOCAL, local);

		String url = (String) session.getAttribute(PAR_OR_ATTR_URL);

		response.sendRedirect(url);
	}
}

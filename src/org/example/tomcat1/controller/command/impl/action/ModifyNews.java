package org.example.tomcat1.controller.command.impl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.service.INewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

import static org.example.tomcat1.controller.command.impl.CommandConstants.*;

public final class ModifyNews
	implements ICommand {

	@Override
	public void execute(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException,
			ControllerException {
		CommandBouncer bouncer = new CommandBouncer();

		if (!bouncer.checkSessionAndAuth(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();

		INewsService newsService = provider.getNewsService();

		try {
			Integer id = Integer.valueOf(
					request.getParameter(PAR_OR_ATTR_ID));

			String title = request.getParameter(PAR_OR_ATTR_TITLE);
			String brief = request.getParameter(PAR_OR_ATTR_BRIEF);
			String content = request.getParameter(
					PAR_OR_ATTR_CONTENT);

			Boolean edited = newsService.editById(
					id, title, brief, content);

			response.sendRedirect("Controller?"
					+ "command=gotonewspage&"
					+ PAR_OR_ATTR_ID + "=" + id
					+ "&" + PAR_OR_ATTR_EDITED
					+ "=" + edited);
		} catch (ServiceException | NumberFormatException e) {
			throw new ControllerException(e);
		}
	}
}


package org.example.tomcat1.controller.command.impl.action;

import static org.example.tomcat1.controller.ControllerConstants.*;

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

public final class DeleteNews
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

			Boolean editResult = newsService.deleteById(id);

			if (editResult) {
				response.sendRedirect("Controller?"
						+ "command=gotomainpage");
			}
		} catch (ServiceException | NumberFormatException e) {
			throw new ControllerException(e);
		}
	}
}


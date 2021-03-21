package org.example.tomcat1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.CommandProvider;

public final class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PAR_OR_ATTR_COMMAND = "command";

	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		String name = request.getParameter(PAR_OR_ATTR_COMMAND);

		ICommand command = provider.takeCommand(name);

		try {
			command.execute(request, response);
		} catch (ControllerException e) {
			RequestDispatcher requestDispatcher = 
					request.getRequestDispatcher(
							"/WEB-INF/jsp/page_error.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}

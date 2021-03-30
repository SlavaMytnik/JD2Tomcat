package org.example.tomcat1.controller.command.impl;

import static org.example.tomcat1.controller.ControllerConstants.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommandBouncer;

public final class CommandBouncer
		implements ICommandBouncer {
	private static final String FORM_FIELD_REGEXP = "[a-zA-Z0-9]+";

	private static final int LIMIT_MIN = 4;
	private static final int LIMIT_MAX = 100;

	@Override
	public boolean checkSession(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ControllerException {
		HttpSession session = request.getSession();

		if (session == null) {
			try {
				response.sendRedirect("Controller?"
						+ "command=gotoindexpage");
			} catch (IOException e) {
				throw new ControllerException(e);
			}

			return false;
		}

		return true;
	}

	@Override
	public boolean checkSessionAndAuth(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ControllerException {
		HttpSession session = request.getSession();

		Boolean isAuth = (Boolean) session
				.getAttribute(PAR_OR_ATTR_AUTH);

		if (session == null || isAuth == null || !isAuth) {
			try {
				response.sendRedirect("Controller?"
						+ "command=gotoindexpage");
			} catch (IOException e) {
				throw new ControllerException(e);
			}

			return false;
		}

		return true;
	}

	@Override
	public boolean checkRegistrationInfo(final HttpServletResponse response,
			final RegistrationInfo regInfo)
					throws ControllerException {
		String login = regInfo.getLogin();
		String password = regInfo.getPassword();
		String name = regInfo.getName();
		String surname = regInfo.getSurname();

		if (login == null
				|| login.length() < LIMIT_MIN
				|| login.length() > LIMIT_MAX
				|| password == null
				|| password.length() < LIMIT_MIN
				|| password.length() > LIMIT_MAX
				|| !login.matches(FORM_FIELD_REGEXP)
				|| !password.matches(FORM_FIELD_REGEXP)
				|| (name.length() > 0
						&& !name.matches(FORM_FIELD_REGEXP))
				|| (surname.length() > 0
						&& !surname.matches(FORM_FIELD_REGEXP))
				|| name.length() > LIMIT_MAX
				|| surname.length() > LIMIT_MAX) {

			try {
				response.sendRedirect("Controller?"
						+ "command=gotoredirectpage&"
						+ PAR_OR_ATTR_ERROR + "=" + ERROR_REGISTRATION);
			} catch (IOException e) {
				throw new ControllerException(e);
			}

			return false;
		}

		return true;
	}

	@Override
	public boolean checkLoginationInfo(final HttpServletResponse response,
			final LoginationInfo logInfo)
					throws ControllerException {
		String login = logInfo.getLogin();
		String password = logInfo.getPassword();

		if (login == null
				|| login.length() < LIMIT_MIN
				|| login.length() > LIMIT_MAX
				|| password == null
				|| password.length() < LIMIT_MIN
				|| password.length() > LIMIT_MAX
				|| !login.matches(FORM_FIELD_REGEXP)
				|| !password.matches(FORM_FIELD_REGEXP)) {

			try {
				response.sendRedirect("Controller?"
						+ "command=gotoredirectpage&"
						+ PAR_OR_ATTR_ERROR + "=" + ERROR_LOGINATION);
			} catch (IOException e) {
				throw new ControllerException(e);
			}

			return false;
		}

		return true;
	}
}

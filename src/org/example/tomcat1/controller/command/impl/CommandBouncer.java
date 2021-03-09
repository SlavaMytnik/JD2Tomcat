package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.controller.command.ICommandBouncer;
import org.example.tomcat1.service.ServiceException;

public class CommandBouncer extends CommandConstants implements ICommandBouncer {

	@Override
	public boolean checkSession(HttpServletRequest request, HttpServletResponse response) 
			throws ServiceException {
		HttpSession session = request.getSession();
		
		if (session == null) {
			try {
				response.sendRedirect("Controller?command=gotoindexpage");
			} catch (IOException e) {
				throw new ServiceException(e);
			}
			
			return false;
		}
		
		return true;
	}

	@Override
	public boolean checkSessionAndAuth(HttpServletRequest request, HttpServletResponse response)
			throws ServiceException {
		HttpSession session = request.getSession();
		
		Boolean isAuth = (Boolean) session.getAttribute(PAR_OR_ATTR_AUTH);

		if (session == null || isAuth == null || !isAuth) {
			try {
				response.sendRedirect("Controller?command=gotoindexpage");
			} catch (IOException e) {
				throw new ServiceException(e);
			}
			
			return false;
		}
		
		return true;
	}

	@Override
	public boolean checkRegistrationInfo(HttpServletResponse response, 
			RegistrationInfo regInfo) throws ServiceException {
		String login = regInfo.getLogin();
		String password = regInfo.getPassword();	
		String name = regInfo.getName();
		String surname = regInfo.getSurname();	
		
		if (login == null || login.length() < 4 || login.length() > 100 
				|| password == null || password.length() < 4 || password.length() > 100 
				|| !login.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| !password.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| (name.length() > 0 && !name.matches("[à-ÿÀ-ßa-zA-Z0-9]+")) 
				|| (surname.length() > 0 && !surname.matches("[à-ÿÀ-ßa-zA-Z0-9]+"))
				|| name.length() > 100 || surname.length() > 100) {
			
			try {
				response.sendRedirect("Controller?command=gotoredirectpage&" + PAR_OR_ATTR_ERROR 
						+ "=" + ERROR_REGISTRATION);
			} catch (IOException e) {
				throw new ServiceException(e);
			}
			
			return false;
		}

		return true;
	}

	@Override
	public boolean checkLoginationInfo(HttpServletResponse response, 
			LoginationInfo logInfo) throws ServiceException {
		String login = logInfo.getLogin();
		String password = logInfo.getPassword();	
		
		if (login == null || login.length() < 4 || login.length() > 100 
				|| password == null || password.length() < 4 || password.length() > 100 
				|| !login.matches("[à-ÿÀ-ßa-zA-Z0-9]+") 
				|| !password.matches("[à-ÿÀ-ßa-zA-Z0-9]+")) {
			
			try {
				response.sendRedirect("Controller?command=gotoredirectpage&" + PAR_OR_ATTR_ERROR 
						+ "=" + ERROR_LOGINATION);
			} catch (IOException e) {
				throw new ServiceException(e);
			}
			
			return false;
		}

		return true;
	}
}

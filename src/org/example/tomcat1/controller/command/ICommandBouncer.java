package org.example.tomcat1.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.service.ServiceException;

public interface ICommandBouncer {
	boolean checkSession(HttpServletRequest request, HttpServletResponse response) 
			throws ServiceException;
	boolean checkSessionAndAuth(HttpServletRequest request, HttpServletResponse response) 
			throws ServiceException;
	boolean checkRegistrationInfo(HttpServletResponse response, RegistrationInfo regInfo) 
			throws ServiceException;
	boolean checkLoginationInfo(HttpServletResponse response, LoginationInfo logInfo) 
			throws ServiceException;
}

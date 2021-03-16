package org.example.tomcat1.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.controller.ControllerException;

public interface ICommandBouncer {
	boolean checkSession(HttpServletRequest request, HttpServletResponse response) 
			throws ControllerException;
	boolean checkSessionAndAuth(HttpServletRequest request, HttpServletResponse response) 
			throws ControllerException;
	boolean checkRegistrationInfo(HttpServletResponse response, RegistrationInfo regInfo) 
			throws ControllerException;
	boolean checkLoginationInfo(HttpServletResponse response, LoginationInfo logInfo) 
			throws ControllerException;
}

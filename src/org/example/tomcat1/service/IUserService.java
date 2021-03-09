package org.example.tomcat1.service;

import org.example.tomcat1.bean.User;
import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;

public interface IUserService {
	User logination(LoginationInfo logInfo) throws ServiceException;
	boolean registration(RegistrationInfo regInfo) throws ServiceException;
}

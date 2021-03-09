package org.example.tomcat1.dao;

import org.example.tomcat1.bean.User;
import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;

public interface IUserDAO {
	User logination(LoginationInfo logInfo) throws DAOException;
	boolean	registration(RegistrationInfo regInfo) throws DAOException;
}

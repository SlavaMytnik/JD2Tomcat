package org.example.tomcat1.service.impl;

import org.example.tomcat1.bean.User;
import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.DAOProvider;
import org.example.tomcat1.dao.IUserDAO;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.IUserService;

public final class UserServiceImpl implements IUserService {

	@Override
	public User logination(final LoginationInfo logInfo)
			throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();

        IUserDAO userDAO = provider.getUserDAO();

		User user = null;

		try {
			user = userDAO.logination(logInfo);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return user;
	}

	@Override
	public boolean registration(final RegistrationInfo regInfo)
			throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();

        IUserDAO userDAO = provider.getUserDAO();

		boolean regResult = false;

		try {
			regResult = userDAO.registration(regInfo);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return regResult;
	}
}

package org.example.tomcat1.dao;

import org.example.tomcat1.dao.impl.SQLNewsDAO;
import org.example.tomcat1.dao.impl.SQLUserDAO;

public final class DAOProvider {
	private static final DAOProvider INSTANCE = new DAOProvider();

	private final IUserDAO userdao = new SQLUserDAO();

	private final INewsDAO newsDAO = new SQLNewsDAO();

	private DAOProvider() {}

	public static DAOProvider getInstance() {
		return INSTANCE;
	}

	public IUserDAO getUserdao() {
		return userdao;
	}

	public INewsDAO getNewsDAO() {
		return newsDAO;
	}
}

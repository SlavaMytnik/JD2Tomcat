package org.example.tomcat1.dao;

import org.example.tomcat1.dao.impl.SQLNewsDAO;
import org.example.tomcat1.dao.impl.SQLUserDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();	
	
	private final IUserDAO userdao = new SQLUserDAO();
	
	private final INewsDAO newsDAO = new SQLNewsDAO();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public IUserDAO getUserdao() {
		return userdao;
	}

	public INewsDAO getNewsDAO() {
		return newsDAO;
	}	
}

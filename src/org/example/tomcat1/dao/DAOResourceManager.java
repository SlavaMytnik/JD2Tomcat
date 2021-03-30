package org.example.tomcat1.dao;

import java.util.ResourceBundle;

import static org.example.tomcat1.dao.DAOConstants.*;

public class DAOResourceManager {
	private final static DAOResourceManager INSTANCE =
			new DAOResourceManager();

	private ResourceBundle bundle = ResourceBundle.getBundle(DB_NAME);

	public static DAOResourceManager getInstance() {
		return INSTANCE;
	}

	public String getValue(String key){
		return bundle.getString(key);
	}
}

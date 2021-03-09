package org.example.tomcat1.dao.impl;

import java.util.ResourceBundle;

import org.example.tomcat1.dao.DBDriverLoadingException;

public class SQLDriverLoader {
	private static final SQLDriverLoader instance = new SQLDriverLoader();

	static {
		try {
			String BUNDLE_SQL = "sql.sql";
			String BUNDLE_DRIVER = "driver";
			
			ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_SQL);
			
			String driverName = bundle.getString(BUNDLE_DRIVER);
			
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException(e);
		}
	}
	
	private SQLDriverLoader() {}
	
	public static SQLDriverLoader getInstance() {
		return instance;
	}
}

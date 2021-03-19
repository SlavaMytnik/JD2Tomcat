package org.example.tomcat1.dao.impl;

import java.util.ResourceBundle;

public final class SQLConstants {
	public static final String CONNECTION_HOST;
	public static final String CONNECTION_LOGIN;
	public static final String CONNECTION_PASSWORD;
	
	static {
		String bundleSQL = "sql.sql";
		String bundleHost = "host";
		String bundleLogin = "login";
		String bundlePassword = "password";
		
		ResourceBundle bundle = ResourceBundle.getBundle(bundleSQL);
		
		CONNECTION_HOST = bundle.getString(bundleHost);
		CONNECTION_LOGIN = bundle.getString(bundleLogin);
		CONNECTION_PASSWORD = bundle.getString(bundlePassword);
	}
	
	public static final String TABLE_USERS = "users";
	public static final String TABLE_NEWS = "news";
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_BRIEF = "brief";
	public static final String COLUMN_CONTENT = "content";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_LOGIN = "login";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_SURNAME = "surname";
	public static final String COLUMN_ROLE = "role";
	
	public static final String STATUS_ACTIVE = "active";
	public static final String STATUS_DELETED = "deleted";
	
	public static final String ROLE_USER = "user";
	
	private SQLConstants() {}
}

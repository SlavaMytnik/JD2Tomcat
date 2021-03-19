package org.example.tomcat1.dao.impl;

import java.util.ResourceBundle;

public final class SQLConstants {
	public static final String CONNECTION_HOST;
	public static final String CONNECTION_LOGIN;
	public static final String CONNECTION_PASSWORD;
	
	static {
		String BUNDLE_SQL = "sql.sql";
		String BUNDLE_HOST = "host";
		String BUNDLE_LOGIN = "login";
		String BUNDLE_PASSWORD = "password";
		
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_SQL);
		
		CONNECTION_HOST = bundle.getString(BUNDLE_HOST);
		CONNECTION_LOGIN = bundle.getString(BUNDLE_LOGIN);
		CONNECTION_PASSWORD = bundle.getString(BUNDLE_PASSWORD);
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

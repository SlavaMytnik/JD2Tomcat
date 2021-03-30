package org.example.tomcat1.dao;

public final class DAOConstants {
	public static final String DB_NAME = "sql.sql";
	public static final String DB_DRIVER = "driver";
	public static final String CONNECTION_HOST = "host";
	public static final String CONNECTION_LOGIN = "login";
	public static final String CONNECTION_PASSWORD = "password";
	public static final String CONNECTION_POOL_SIZE = "poolsize";

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

	private DAOConstants() {}
}

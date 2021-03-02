package org.example.tomcat1.dao;

public class DBDriverLoadingException extends RuntimeException{
	private static final long serialVersionUID = -2825413958976117198L;

	public DBDriverLoadingException(Exception e) {
		super(e);
	}
}

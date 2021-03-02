package org.example.tomcat1.dao;

public class DAOException extends Exception {
	private static final long serialVersionUID = -2770244259091737269L;

	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}

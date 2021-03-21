package org.example.tomcat1.dao;

public class DAOException extends Exception {
	private static final long serialVersionUID = -2770244259091737269L;

	public DAOException() {
		super();
	}

	public DAOException(final String message) {
		super(message);
	}

	public DAOException(final Exception e) {
		super(e);
	}

	public DAOException(final String message, final Exception e) {
		super(message, e);
	}
}

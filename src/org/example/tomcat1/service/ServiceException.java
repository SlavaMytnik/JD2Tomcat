package org.example.tomcat1.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -2593140301428014170L;

	public ServiceException() {
		super();
	}

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final Exception e) {
		super(e);
	}

	public ServiceException(final String message, final Exception e) {
		super(message, e);
	}
}

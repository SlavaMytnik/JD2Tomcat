package org.example.tomcat1.controller;

public class ControllerException extends Exception {
	private static final long serialVersionUID = 5828266359499746615L;

	public ControllerException() {
		super();
	}

	public ControllerException(final String message) {
		super(message);
	}

	public ControllerException(final Exception e) {
		super(e);
	}

	public ControllerException(final String message, final Exception e) {
		super(message, e);
	}
}

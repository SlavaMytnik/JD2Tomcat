package org.example.tomcat1.controller;

public class ControllerException extends Exception {
	private static final long serialVersionUID = 5828266359499746615L;

	public ControllerException() {
		super();
	}
	
	public ControllerException(String message) {
		super(message);
	}
	
	public ControllerException(Exception e) {
		super(e);
	}
	
	public ControllerException(String message, Exception e) {
		super(message, e);
	}
}

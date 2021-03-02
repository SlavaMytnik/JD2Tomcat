package org.example.tomcat1.bean;

public class LoginationInfo {
	private String login;
	private String password;
	
	public LoginationInfo(String login, String password) {
		super();
		
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}

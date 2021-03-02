package org.example.tomcat1.bean;

public class RegistrationInfo {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String status;
	private String role;
	
	public RegistrationInfo(String login, String password, String name, 
			String surname, String status, String role) {
		super();
		
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.status = status;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}		
}

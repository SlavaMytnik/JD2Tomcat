package org.example.tomcat1.bean;

import java.io.Serializable;

public final class LoginationInfo implements Serializable {
	private static final long serialVersionUID = -67647972223308663L;

	private String login;
	private String password;

	public LoginationInfo() {
		super();
	}

	public LoginationInfo(final String login, final String password) {
		super();

		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result
				+ ((login == null) ? 0
						: login.hashCode());
		result = prime * result
				+ ((password == null) ? 0
						: password.hashCode());

		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		LoginationInfo other = (LoginationInfo) obj;

		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}

		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "LoginationInfo [login="
				+ login + ", password="
				+ password + "]";
	}
}

package org.example.tomcat1.bean;

import java.io.Serializable;

public final class RegistrationInfo implements Serializable {
	private static final long serialVersionUID = -8044891239067496302L;

	private String login;
	private String password;
	private String name;
	private String surname;
	private String status;
	private String role;

	public RegistrationInfo() {
		super();
	}

	public RegistrationInfo(final String login, final String password,
			final String name, final String surname,
			final String status, final String role) {
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

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((login == null) ? 0
						: login.hashCode());
		result = prime * result
				+ ((name == null) ? 0
						: name.hashCode());
		result = prime * result
				+ ((password == null) ? 0
						: password.hashCode());
		result = prime * result
				+ ((role == null) ? 0
						: role.hashCode());
		result = prime * result
				+ ((status == null) ? 0
						: status.hashCode());
		result = prime * result
				+ ((surname == null) ? 0
						: surname.hashCode());

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

		RegistrationInfo other = (RegistrationInfo) obj;

		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}

		if (role == null) {
			if (other.role != null) {
				return false;
			}
		} else if (!role.equals(other.role)) {
			return false;
		}

		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}

		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "RegistrationInfo [login=" + login
				+ ", password=" + password
				+ ", name=" + name
				+ ", surname=" + surname
				+ ", status=" + status
				+ ", role=" + role + "]";
	}
}

package org.example.tomcat1.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.bean.User;
import org.example.tomcat1.dao.DAOConnectionPool;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.IUserDAO;

import static org.example.tomcat1.dao.DAOConstants.*;

public final class SQLUserDAO implements IUserDAO {
	private static final DAOConnectionPool CONNECTION_POOL;

	static {
		CONNECTION_POOL = DAOConnectionPool.getInstance();
	}

	@Override
	public User logination(final LoginationInfo logInfo)
			throws DAOException {
		User user = null;

		Connection con = null;

		Statement st = null;

		ResultSet rs = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();

			String login = logInfo.getLogin();
			String password = logInfo.getPassword();

			rs = st.executeQuery("SELECT * FROM "
					+ TABLE_USERS
					+ " WHERE "
					+ COLUMN_LOGIN + " = '" + login
					+ "' AND "
					+ COLUMN_PASSWORD + " = '" + password
					+ "' AND "
					+ COLUMN_STATUS + " = '" + STATUS_ACTIVE
					+ "';");

			if (rs.next()) {
				String name = rs.getString(COLUMN_NAME);
				String surname = rs.getString(COLUMN_SURNAME);
				String role = rs.getString(COLUMN_ROLE);

				user = new User(login, name, surname, role);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st, rs);
		}

		return user;
	}

	@Override
	public boolean registration(final RegistrationInfo regInfo)
			throws DAOException {
		Boolean regResult = false;

		Connection con = null;

		Statement st = null;

		ResultSet rs = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();

			String login = regInfo.getLogin();

			rs = st.executeQuery("SELECT * FROM "
					+ TABLE_USERS
					+ " WHERE "
					+ COLUMN_LOGIN + " = '" + login
					+ "';");

			if (!rs.next()) {
				String password = regInfo.getPassword();
				String name = regInfo.getName();
				String surname = regInfo.getSurname();

				String query = "INSERT INTO "
						+ TABLE_USERS
						+ " (" + COLUMN_LOGIN + ", " + COLUMN_PASSWORD
						+ ", " + COLUMN_NAME + ", " + COLUMN_SURNAME
						+ ", " + COLUMN_STATUS + ", " + COLUMN_ROLE + ")"
						+ " VALUES "
						+ "('" + login + "', '" + password
						+ "', '" + name + "', '" + surname
						+ "', '" + STATUS_ACTIVE + "', '" + ROLE_USER + "');";

				int col = st.executeUpdate(query);

				if (col > 0) {
					regResult = true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st, rs);
		}

		return regResult;
	}
}

package org.example.tomcat1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.tomcat1.bean.LoginationInfo;
import org.example.tomcat1.bean.RegistrationInfo;
import org.example.tomcat1.bean.User;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.IUserDAO;

import static org.example.tomcat1.dao.impl.SQLConstants.*;

public class SQLUserDAO implements IUserDAO {

	@Override
	public User logination(LoginationInfo logInfo) throws DAOException {
		User user = null;

		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {		
			Statement st = con.createStatement();
			
			String login = logInfo.getLogin();
			String password = logInfo.getPassword();
			
			ResultSet rs = st.executeQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_LOGIN + " = '" + login 
					+ "' AND " + COLUMN_PASSWORD + " = '" + password + "' AND " + COLUMN_STATUS + " = '" + STATUS_ACTIVE + "';");
			
			if (rs.next()) {
				String name = rs.getString(COLUMN_NAME);
				String surname = rs.getString(COLUMN_SURNAME);
				String role = rs.getString(COLUMN_ROLE);
				
				user = new User(login, name, surname, role);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		
		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws DAOException {
		Boolean regResult = false;
		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {		
			Statement st = con.createStatement();
			
			String login = regInfo.getLogin();
			
			ResultSet rs = st.executeQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_LOGIN + " = '" + login + "';");
			
			if (!rs.next()) {
				String password = regInfo.getPassword();
				String name = regInfo.getName();
				String surname = regInfo.getSurname();
				
				String STRING_QUARY = "INSERT INTO " + TABLE_USERS + " (" + COLUMN_LOGIN + ", " + COLUMN_PASSWORD 
						+ ", " + COLUMN_NAME + ", " + COLUMN_SURNAME + ", " + COLUMN_STATUS + ", " + COLUMN_ROLE + ") "
						+ "VALUES ('" + login + "', '" + password + "', '" + name 
						+ "', '" + surname + "', '" + STATUS_ACTIVE + "', '" + ROLE_USER + "');";
				
				int col = st.executeUpdate(STRING_QUARY);
				
				if (col > 0) {
					regResult = true;
				} 
			}			
		} catch (SQLException e) {
			throw new DAOException(e);
		} 

		return regResult;
	}
}

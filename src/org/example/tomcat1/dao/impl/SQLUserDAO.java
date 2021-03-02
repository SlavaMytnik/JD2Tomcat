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
import org.example.tomcat1.dao.UserDAO;

public class SQLUserDAO implements UserDAO{
	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Override
	public User logination(LoginationInfo logInfo) throws DAOException {
		Connection con = null;
		
		User user = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			String login = logInfo.getLogin();
			String password = logInfo.getPassword();
			
			ResultSet rs = st.executeQuery("SELECT * FROM users WHERE login='" + login 
					+ "' AND password='" + password + "' AND status='active';");
			
			if (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String role = rs.getString("role");
				
				user = new User(login, password, name, surname, role);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws DAOException {
		Connection con = null;
		
		Boolean regResult = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			String login = regInfo.getLogin();
			
			ResultSet rs = st.executeQuery("SELECT * FROM users WHERE login='" + login + "';");
			
			if (!rs.next()) {
				String password = regInfo.getPassword();
				String name = regInfo.getName();
				String surname = regInfo.getSurname();
				
				String STRING_QUARY = "INSERT INTO users (login, password, name, surname, status, role) "
						+ "VALUES ('" + login + "', '" + password + "', '" + name 
						+ "', '" + surname + "', 'active', 'user');";
				
				int col = st.executeUpdate(STRING_QUARY);
				
				if (col > 0) {
					regResult = true;
				} 
			}			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return regResult;
	}
}

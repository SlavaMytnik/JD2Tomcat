package org.example.tomcat1.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// FOR TEST ONLY!
public class ContextListener implements ServletContextListener {
	private static final String BUNDLE_SQL = "sql.sql";
	private static final String BUNDLE_DRIVER = "driver";
	private static final String BUNDLE_HOST = "host";
	private static final String BUNDLE_LOGIN = "login";
	private static final String BUNDLE_PASSWORD = "password";
	
	private static final String ATTR_CONNECTION = "sqlcon";
	
	public void contextInitialized(ServletContextEvent event) { 
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_SQL);
		
		String driver = bundle.getString(BUNDLE_DRIVER);
		String host = bundle.getString(BUNDLE_HOST);
		String login = bundle.getString(BUNDLE_LOGIN);
		String password = bundle.getString(BUNDLE_PASSWORD);
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		try (Connection con = DriverManager.getConnection(host, login, password)) {						
			ServletContext context = event.getServletContext();  
			context.setAttribute(ATTR_CONNECTION, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {} 
}

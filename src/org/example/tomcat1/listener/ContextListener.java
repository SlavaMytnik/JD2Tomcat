package org.example.tomcat1.listener;

import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	private static final String BUNDLE_SQL = "sql.sql";
	private static final String BUNDLE_DRIVER = "driver";
	
	public void contextInitialized(ServletContextEvent event) { 
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_SQL);
		
		String driver = bundle.getString(BUNDLE_DRIVER);
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {} 
}

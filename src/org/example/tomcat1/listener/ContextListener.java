package org.example.tomcat1.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.example.tomcat1.dao.DAOConnectionPool;
import org.example.tomcat1.dao.DAOException;

public final class ContextListener implements ServletContextListener {
	private static final String PAR_OR_ATTR_CONNECTION_SUCCESS =
			"connection";

	private static final DAOConnectionPool CONNECTION_POOL;

	static {
		CONNECTION_POOL = DAOConnectionPool.getInstance();
	}

	public void contextInitialized(final ServletContextEvent event) {
		ServletContext context = event.getServletContext();

		try {
			CONNECTION_POOL.initPoolData();

			context.setAttribute(
					PAR_OR_ATTR_CONNECTION_SUCCESS, true);
		} catch (DAOException e) {
			context.setAttribute(
					PAR_OR_ATTR_CONNECTION_SUCCESS, false);
		}
	}

	public void contextDestroyed(final ServletContextEvent arg0) {
		try {
			CONNECTION_POOL.dispose();
		} catch (DAOException e) {
			//e.printStackTrace();
		}
	}
}

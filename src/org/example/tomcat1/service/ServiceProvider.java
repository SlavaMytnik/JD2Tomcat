package org.example.tomcat1.service;

import org.example.tomcat1.service.impl.NewsServiceImpl;
import org.example.tomcat1.service.impl.UserServiceImpl;

public final class ServiceProvider {	
	private static final ServiceProvider instance = new ServiceProvider(); 

	private ServiceProvider() {}
	
	private final UserService userService = new UserServiceImpl();
	
	private final NewsService newsService = new NewsServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public NewsService getNewsService() {
		return newsService;
	}	
}

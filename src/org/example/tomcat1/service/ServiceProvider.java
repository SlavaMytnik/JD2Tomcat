package org.example.tomcat1.service;

import org.example.tomcat1.service.impl.NewsServiceImpl;
import org.example.tomcat1.service.impl.UserServiceImpl;

public final class ServiceProvider {	
	private static final ServiceProvider instance = new ServiceProvider(); 

	private ServiceProvider() {}
	
	private final IUserService userService = new UserServiceImpl();
	
	private final INewsService newsService = new NewsServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public IUserService getUserService() {
		return userService;
	}

	public INewsService getNewsService() {
		return newsService;
	}	
}

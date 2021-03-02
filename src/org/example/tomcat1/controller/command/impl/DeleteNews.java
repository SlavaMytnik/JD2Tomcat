package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.command.Command;
import org.example.tomcat1.service.NewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

public class DeleteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		Boolean isAuth = (Boolean) session.getAttribute("auth");

		if (session == null || isAuth == null || !isAuth) {
			response.sendRedirect("Controller?command=gotoindexpage");
			
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		
		NewsService newsService = provider.getNewsService();

		Integer id = Integer.valueOf(request.getParameter("id"));
		
		try {
			Boolean editResult = newsService.deleteById(id);			
			
			if (editResult) response.sendRedirect("Controller?command=gotomainpage");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}


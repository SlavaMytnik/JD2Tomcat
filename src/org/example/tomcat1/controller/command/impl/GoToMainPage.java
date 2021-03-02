package org.example.tomcat1.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.controller.command.Command;
import org.example.tomcat1.service.NewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

public class GoToMainPage implements Command {
	
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

		try {
			List<News> news = newsService.getAll();
			
			String url = request.getRequestURL() + "?" + request.getQueryString();
			
			session.setAttribute("url", url);			
			request.setAttribute("news", news);			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);		
		} catch (ServiceException e) {
			e.printStackTrace();
		}	
	}
}

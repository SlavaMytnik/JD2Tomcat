package org.example.tomcat1.controller.command.impl.gotopage;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandConstants;
import org.example.tomcat1.service.INewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

public class GoToIndexPage extends CommandConstants implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ServiceException {
		ServiceProvider provider = ServiceProvider.getInstance();
		
		HttpSession session = request.getSession();
		
		INewsService newsService = provider.getNewsService();
		
		try {
			List<News> news = newsService.getAll();
			
			String url = request.getRequestURL() + "?" + request.getQueryString();
			
			session.setAttribute(PAR_OR_ATTR_URL, url);			
			request.setAttribute(PAR_OR_ATTR_NEWS, news);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page_index.jsp");
			requestDispatcher.forward(request, response);			
		} catch (ServiceException e) {
			throw new ServiceException(e);
		}	
	}
}
